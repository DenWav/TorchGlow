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

import com.demonwav.torchglow.TorchType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

interface TorchElement {

    val project: Project

    val type: TorchType

    val element: PsiElement
}
