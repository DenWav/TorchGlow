/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

@file:JvmName("TorchAnnotations")

package com.demonwav.torchglow.psi

interface TorchAnnotation : TorchElement {

    val holderElement: TorchElement

    val values: Set<TorchAnnotationValue>
}

fun TorchAnnotation.findAnnotationValue(name: String) = values.firstOrNull { it.name == name }
