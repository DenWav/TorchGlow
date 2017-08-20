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
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiModifier
import org.jetbrains.uast.java.annotations

open class TorchJavaClass(protected val psiClass: PsiClass) : TorchJavaNamedElement(psiClass), TorchClass {

    override val simpleName: String?
        get() = psiClass.name

    override val jvmName: String
        get() = TODO()

    override val members: Set<TorchMember> by lazy {
        methods + fields
    }

    override val methods: Set<TorchMethod> by lazy {
        psiClass.methods.mapTo(HashSet(), ::TorchJavaMethod)
    }

    override val fields: Set<TorchField> by lazy {
        psiClass.fields.mapTo(HashSet(), ::TorchJavaField)
    }

    override val containingPackage: TorchPackage? by lazy {
        val packageName = (psiClass.containingFile as PsiJavaFile).packageName
        val psiPackage = JavaPsiFacade.getInstance(project).findPackage(packageName) ?: return@lazy null
        TorchJavaPackage(psiPackage)
    }

    override val containingClass: TorchClass? by lazy {
        val psiContainingClass = psiClass.containingClass ?: return@lazy null
        TorchJavaClass(psiContainingClass)
    }

    override val containedClasses: Set<TorchClass> by lazy {
        psiClass.innerClasses.mapTo(HashSet(), ::TorchJavaClass)
    }

    override val superClass: TorchClass? by lazy {
        val superClass = psiClass.superClass ?: return@lazy null
        TorchJavaClass(superClass)
    }

    override val supers: Set<TorchClass> by lazy {
        psiClass.supers.mapTo(HashSet(), ::TorchJavaClass)
    }

    override val modifiers: Set<String> by lazy {
        val list = psiClass.modifierList!!
        PsiModifier.MODIFIERS.filterTo(HashSet()) { list.hasModifierProperty(it) }
    }

    override val annotations: Set<TorchAnnotation> by lazy {
        psiClass.annotations.mapTo(HashSet(), ::TorchJavaAnnotation)
    }
}
