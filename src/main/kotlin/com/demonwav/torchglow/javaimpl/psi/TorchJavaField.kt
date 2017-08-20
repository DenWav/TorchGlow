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
import com.demonwav.torchglow.psi.TorchField
import com.intellij.psi.PsiField
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiType
import org.jetbrains.uast.java.annotations

class TorchJavaField(private val psiField: PsiField) : TorchJavaMember(psiField), TorchField {

    override val jvmType: String
        get() = TODO()

    override val psiType: PsiType
        get() = psiField.type

    override val simpleName: String
        get() = psiField.name!!

    override val jvmName: String
        get() = TODO()

    override val modifiers: Set<String> by lazy {
        val list = psiField.modifierList!!
        PsiModifier.MODIFIERS.filterTo(HashSet()) { list.hasModifierProperty(it) }
    }

    override val annotations: Set<TorchAnnotation> by lazy {
        psiField.annotations.mapTo(HashSet(), ::TorchJavaAnnotation)
    }
}
