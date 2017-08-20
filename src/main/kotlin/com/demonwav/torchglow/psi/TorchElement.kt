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

import com.intellij.psi.PsiElement

interface TorchElement : PsiElement {

    val element: PsiElement
}
