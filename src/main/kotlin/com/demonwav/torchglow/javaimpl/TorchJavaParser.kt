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

import com.demonwav.torchglow.TorchParser
import com.demonwav.torchglow.javaimpl.psi.TorchJavaAnnotation
import com.demonwav.torchglow.javaimpl.psi.TorchJavaClass
import com.demonwav.torchglow.javaimpl.psi.TorchJavaEnum
import com.demonwav.torchglow.javaimpl.psi.TorchJavaEnumValue
import com.demonwav.torchglow.javaimpl.psi.TorchJavaField
import com.demonwav.torchglow.javaimpl.psi.TorchJavaMethod
import com.demonwav.torchglow.javaimpl.psi.TorchJavaPackage
import com.demonwav.torchglow.psi.TorchAnnotation
import com.demonwav.torchglow.psi.TorchClass
import com.demonwav.torchglow.psi.TorchEnum
import com.demonwav.torchglow.psi.TorchEnumValue
import com.demonwav.torchglow.psi.TorchField
import com.demonwav.torchglow.psi.TorchMethod
import com.demonwav.torchglow.psi.TorchPackage
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiEnumConstant
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiPackage
import java.util.concurrent.ConcurrentHashMap

class TorchJavaParser(project: Project) : TorchParser<PsiClass> {

    private val elementCache = JavaElementCache.getInstance(project)

    override fun buildStructure(element: PsiClass): TorchClass {
        return elementCache.getElement(element) as TorchClass
    }

    fun parseClass(psiClass: PsiClass): TorchClass = TorchJavaClass(psiClass)
    fun parseMethod(method: PsiMethod): TorchMethod = TorchJavaMethod(method)
    fun parseField(field: PsiField): TorchField = TorchJavaField(field)
    fun parsePackage(psiPackage: PsiPackage): TorchPackage = TorchJavaPackage(psiPackage)
    fun parseAnnotation(annotation: PsiAnnotation): TorchAnnotation = TorchJavaAnnotation(annotation)

    fun parseEnum(psiClass: PsiClass): TorchEnum {
        if (!psiClass.isEnum) {
            throw IllegalStateException("psiClass must be an enum")
        }

        return TorchJavaEnum(psiClass)
    }

    fun parseEnumValue(constant: PsiEnumConstant): TorchEnumValue = TorchJavaEnumValue(constant)

    companion object {
        private val map = ConcurrentHashMap<String, TorchJavaParser>()

        fun getInstance(project: Project) = map.computeIfAbsent(project.locationHash) { TorchJavaParser(project) }
    }
}
