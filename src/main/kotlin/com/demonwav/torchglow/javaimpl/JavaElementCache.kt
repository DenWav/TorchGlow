/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow.javaimpl

import com.demonwav.torchglow.psi.TorchElement
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiEnumConstant
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiPackage
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.ParameterizedCachedValue
import com.intellij.psi.util.ParameterizedCachedValueProvider
import com.intellij.psi.util.PsiModificationTracker
import java.util.concurrent.ConcurrentHashMap

class JavaElementCache(private val project: Project) : ParameterizedCachedValueProvider<TorchElement, PsiElement> {

    private val parser = TorchJavaParser.getInstance(project)

    fun getElement(psi: PsiElement): TorchElement? {
        return CachedValuesManager.getManager(project).getParameterizedCachedValue(psi, KEY, this, true, psi)
    }

    private fun createResult(element: TorchElement): CachedValueProvider.Result<TorchElement> {
        return CachedValueProvider.Result.createSingleDependency(element, PsiModificationTracker.JAVA_STRUCTURE_MODIFICATION_COUNT)
    }

    override fun compute(param: PsiElement): CachedValueProvider.Result<TorchElement>? {
        val torchElement: TorchElement = when (param) {
            is PsiClass -> {
                if (param.isEnum) {
                    parser.parseEnum(param)
                } else {
                    parser.parseClass(param)
                }
            }
            is PsiMethod -> parser.parseMethod(param)
            is PsiField -> parser.parseField(param)
            is PsiPackage -> parser.parsePackage(param)
            is PsiAnnotation -> parser.parseAnnotation(param)
            is PsiEnumConstant -> parser.parseEnumValue(param)
            else -> throw IllegalArgumentException("param of type ${param.javaClass.name} not supported")
        }

        return createResult(torchElement)
    }

    companion object {
        val KEY = Key.create<ParameterizedCachedValue<TorchElement, PsiElement>>("TorchJavaElementCache")
        private val map = ConcurrentHashMap<String, JavaElementCache>()

        fun getInstance(project: Project) = map.computeIfAbsent(project.locationHash) { JavaElementCache(project) }
    }
}
