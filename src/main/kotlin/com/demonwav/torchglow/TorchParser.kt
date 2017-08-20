/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow

import com.demonwav.torchglow.psi.TorchClass

interface TorchParser<in T> {

    fun buildStructure(element: T): TorchClass
}
