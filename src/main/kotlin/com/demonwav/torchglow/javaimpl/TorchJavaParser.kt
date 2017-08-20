/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow.javaimpl

import com.demonwav.torchglow.TorchParser
import com.demonwav.torchglow.javaimpl.psi.TorchJavaClass
import com.demonwav.torchglow.javaimpl.psi.TorchJavaEnum
import com.demonwav.torchglow.psi.TorchClass
import com.intellij.psi.PsiClass

object TorchJavaParser : TorchParser<PsiClass> {

    override fun buildStructure(element: PsiClass): TorchClass {
        if (element.isEnum) {
            return TorchJavaEnum(element)
        }

        return TorchJavaClass(element)
    }
}
