/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow

import com.intellij.psi.PsiModifier

interface TorchModifierHolder {

    val modifiers: Set<PsiModifier>
}
