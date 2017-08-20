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
import com.demonwav.torchglow.psi.TorchPackage
import com.intellij.psi.PsiPackage

class TorchJavaPackage(private val psiPackage: PsiPackage) : TorchJavaElement(psiPackage), TorchPackage {

    override val name: String
        get() = psiPackage.qualifiedName

    override val classes: Set<TorchClass> by lazy {
        psiPackage.classes.mapTo(HashSet(), ::TorchJavaClass)
    }
}
