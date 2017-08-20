/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow.psi

import com.intellij.psi.PsiType

interface TorchField : TorchMember {

    val jvmType: String

    val psiType: PsiType?
}
