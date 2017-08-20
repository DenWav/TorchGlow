/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow.javaimpl.psi

import com.demonwav.torchglow.javaimpl.JavaElementCache
import com.demonwav.torchglow.psi.TorchAnnotation
import com.demonwav.torchglow.psi.TorchMethod
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiType
import org.jetbrains.uast.java.annotations

class TorchJavaMethod(private val method: PsiMethod) : TorchJavaMember(method), TorchMethod {

    private val cache = JavaElementCache.getInstance(method.project)

    override val modifiers: Set<String>
        get() {
            val list = method.modifierList
            return PsiModifier.MODIFIERS.filterTo(HashSet()) { list.hasModifierProperty(it) }
        }

    override val simpleName: String
        get() = method.name

    override val jvmName: String
        get() = TODO()

    override val annotations: Set<TorchAnnotation>
        get() = method.annotations.mapTo(HashSet()) { cache.getElement(it) as TorchAnnotation }

    override val jvmReturnTypeName: String
        get() = TODO()

    override val jvmParamList: Set<String>
        get() = TODO()

    override val returnType: PsiType?
        get() = method.returnType

    override val paramList: Set<PsiType>
        get() = method.parameterList.parameters.mapTo(HashSet()) { it.type }

    override val superMethods: Set<TorchMethod>
        get() = method.findSuperMethods().mapTo(HashSet()) { cache.getElement(it) as TorchMethod }
}
