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

import com.demonwav.torchglow.TorchModifierHolder
import com.demonwav.torchglow.TorchType

interface TorchClass : TorchNamedElement, TorchModifierHolder, TorchAnnotationHolder {

    val members: Set<TorchMember>

    val methods: Set<TorchMethod>

    val fields: Set<TorchField>

    val containingPackage: TorchPackage

    val containingClass: TorchClass?

    val containedClases: Set<TorchClass>

    val superClass: TorchClass

    val supers: Set<TorchClass>

    val type: TorchType
}
