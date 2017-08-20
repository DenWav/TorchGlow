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

interface TorchNamedElement : TorchElement {

    val simpleName: String?

    val jvmName: String
}
