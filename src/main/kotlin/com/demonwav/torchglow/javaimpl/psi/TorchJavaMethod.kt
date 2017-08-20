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

import com.demonwav.torchglow.psi.TorchAnnotation
import com.demonwav.torchglow.psi.TorchMethod
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiType
import org.jetbrains.uast.java.annotations

class TorchJavaMethod(private val method: PsiMethod) : TorchJavaMember(method), TorchMethod {

    override val modifiers: Set<String> by lazy {
        val list = method.modifierList
        PsiModifier.MODIFIERS.filterTo(HashSet()) { list.hasModifierProperty(it) }
    }

    override val simpleName: String
        get() = method.name

    override val jvmName: String
        get() = TODO()

    override val annotations: Set<TorchAnnotation> by lazy {
        method.annotations.mapTo(HashSet(), ::TorchJavaAnnotation)
    }

    override val jvmReturnTypeName: String
        get() = TODO()

    override val jvmParamList: Set<String>
        get() = TODO()

    override val returnType: PsiType?
        get() = method.returnType

    override val paramList: Set<PsiType> by lazy {
        method.parameterList.parameters.mapTo(HashSet()) { it.type }
    }

    override val superMethods: Set<TorchMethod> by lazy {
        method.findSuperMethods().mapTo(HashSet(), ::TorchJavaMethod)
    }
}
