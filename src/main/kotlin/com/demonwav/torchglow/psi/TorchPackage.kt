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

interface TorchPackage : TorchElement {

    val name: String

    val classes: Set<TorchClass>
}
