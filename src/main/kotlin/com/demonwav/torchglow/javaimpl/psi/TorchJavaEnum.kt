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
import com.demonwav.torchglow.psi.TorchEnum
import com.demonwav.torchglow.psi.TorchEnumValue
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiEnumConstant

class TorchJavaEnum(psiClass: PsiClass) : TorchJavaClass(psiClass), TorchEnum {

    private val cache = JavaElementCache.getInstance(psiClass.project)

    override val values: Set<TorchEnumValue>
        get() = psiClass.fields.asSequence().filter { it is PsiEnumConstant }.mapTo(HashSet()) { cache.getElement(it) as TorchEnumValue }
}
