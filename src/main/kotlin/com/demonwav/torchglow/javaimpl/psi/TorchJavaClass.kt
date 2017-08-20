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

import com.demonwav.torchglow.psi.TorchAnnotation
import com.demonwav.torchglow.psi.TorchClass
import com.demonwav.torchglow.psi.TorchField
import com.demonwav.torchglow.psi.TorchMember
import com.demonwav.torchglow.psi.TorchMethod
import com.demonwav.torchglow.psi.TorchPackage
import com.intellij.psi.PsiClass

open class TorchJavaClass(protected val psiClass: PsiClass) : TorchJavaNamedElement(psiClass), TorchClass {

    override val simpleName: String?
        get() = TODO()

    override val jvmName: String
        get() = TODO()

    override val members: Set<TorchMember>
        get() = TODO()

    override val methods: Set<TorchMethod>
        get() = TODO()

    override val fields: Set<TorchField>
        get() = TODO()

    override val containingPackage: TorchPackage
        get() = TODO()

    override val containingClass: TorchClass?
        get() = TODO()

    override val containedClasses: Set<TorchClass>
        get() = TODO()

    override val superClass: TorchClass
        get() = TODO()

    override val supers: Set<TorchClass>
        get() = TODO()

    override val modifiers: Set<String>
        get() = TODO()

    override val annotations: Set<TorchAnnotation>
        get() = TODO()
}
