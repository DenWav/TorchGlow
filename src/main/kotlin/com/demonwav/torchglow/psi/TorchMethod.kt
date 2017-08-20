/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

@file:JvmName("TorchMethods")

package com.demonwav.torchglow.psi

import com.intellij.psi.PsiType

interface TorchMethod : TorchMember {

    val jvmReturnTypeName: String

    val jvmParamList: Set<String>

    val returnType: PsiType?

    val paramList: Set<PsiType?>

    val superMethods: Set<TorchMethod>
}

val TorchMethod.jvmParamListString
    get() = jvmParamList.joinToString("")

val TorchMethod.jvmFullyQualifiedName
    get() = "$jvmName($jvmParamListString)$jvmReturnTypeName"
