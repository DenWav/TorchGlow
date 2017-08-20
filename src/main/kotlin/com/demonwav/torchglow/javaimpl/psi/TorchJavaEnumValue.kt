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
import com.demonwav.torchglow.psi.TorchClass
import com.demonwav.torchglow.psi.TorchEnumValue
import com.intellij.psi.PsiEnumConstant

class TorchJavaEnumValue(private val constant: PsiEnumConstant) : TorchJavaElement(constant), TorchEnumValue {

    private val cache = JavaElementCache.getInstance(constant.project)

    override val name: String
        get() = constant.name!!

    override val containingClass: TorchClass
        get() = cache.getElement(constant.containingClass!!) as TorchClass
}
