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
import com.demonwav.torchglow.psi.TorchPackage
import com.intellij.psi.PsiPackage

class TorchJavaPackage(private val psiPackage: PsiPackage) : TorchJavaElement(psiPackage), TorchPackage {

    private val cache = JavaElementCache.getInstance(psiPackage.project)

    override val name: String
        get() = psiPackage.qualifiedName

    override val classes: Set<TorchClass>
        get() = psiPackage.classes.mapTo(HashSet()) { cache.getElement(it) as TorchClass }
}
