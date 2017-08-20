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
import com.demonwav.torchglow.psi.TorchField
import com.intellij.psi.PsiField
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiType
import org.jetbrains.uast.java.annotations

class TorchJavaField(private val psiField: PsiField) : TorchJavaMember(psiField), TorchField {

    private val cache = JavaElementCache.getInstance(psiField.project)

    override val jvmType: String
        get() = TODO()

    override val psiType: PsiType
        get() = psiField.type

    override val simpleName: String
        get() = psiField.name!!

    override val jvmName: String
        get() = TODO()

    override val modifiers: Set<String>
        get() {
            val list = psiField.modifierList!!
            return PsiModifier.MODIFIERS.asSequence().filter { list.hasModifierProperty(it) }.toCollection(HashSet())
        }

    override val annotations: Set<TorchAnnotation>
        get() = psiField.annotations.mapTo(HashSet()) { cache.getElement(it) as TorchAnnotation }
}
