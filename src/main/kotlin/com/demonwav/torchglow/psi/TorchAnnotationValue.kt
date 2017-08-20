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

interface TorchAnnotationValue : TorchElement {

    val annotation: TorchAnnotation

    val name: String?

    val value: String?
}
