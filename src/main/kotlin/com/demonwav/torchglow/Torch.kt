/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

@file:JvmName("Torch")

package com.demonwav.torchglow

import com.demonwav.torchglow.javaimpl.TorchJavaParser
import com.demonwav.torchglow.psi.TorchClass
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement

fun ignite(element: PsiElement): TorchClass? {
    val project = element.project

    // Java support only atm
    if (element is PsiClass) {
        return TorchJavaParser.getInstance(project).buildStructure(element)
    }

    return null
}
