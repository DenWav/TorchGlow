/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow.java

import com.demonwav.torchglow.TorchParser
import com.demonwav.torchglow.psi.TorchClass
import com.intellij.psi.PsiClass

object TorchJavaParser : TorchParser<PsiClass> {

    override fun buildStructure(element: PsiClass): TorchClass {
        TODO()
    }
}
