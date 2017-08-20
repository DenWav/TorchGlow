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
import com.demonwav.torchglow.psi.TorchMember
import com.intellij.psi.PsiMember

abstract class TorchJavaMember(private val member: PsiMember) : TorchJavaNamedElement(member), TorchMember {

    override val containingClass: TorchClass by lazy {
        TorchJavaClass(member.containingClass!!)
    }
}
