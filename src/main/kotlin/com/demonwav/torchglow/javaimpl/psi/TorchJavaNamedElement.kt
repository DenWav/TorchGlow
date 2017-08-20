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

import com.demonwav.torchglow.psi.TorchNamedElement
import com.intellij.psi.PsiElement

abstract class TorchJavaNamedElement(element: PsiElement) : TorchJavaElement(element), TorchNamedElement
