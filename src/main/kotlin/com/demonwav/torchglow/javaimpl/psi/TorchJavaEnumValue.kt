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

import com.demonwav.torchglow.psi.TorchClass
import com.demonwav.torchglow.psi.TorchEnumValue
import com.intellij.psi.PsiEnumConstant

class TorchJavaEnumValue(private val constant: PsiEnumConstant) : TorchJavaElement(constant), TorchEnumValue {

    override val name: String
        get() = constant.name!!

    override val containingClass: TorchClass by lazy {
        TorchJavaClass(constant.containingClass!!)
    }
}
