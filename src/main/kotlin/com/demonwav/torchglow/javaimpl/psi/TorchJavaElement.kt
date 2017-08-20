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

import com.demonwav.torchglow.TorchType
import com.demonwav.torchglow.psi.TorchElement
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

abstract class TorchJavaElement(override val element: PsiElement) : TorchElement {
    override val type: TorchType
        get() = TorchType.JAVA

    override val project: Project
        get() = element.project
}
