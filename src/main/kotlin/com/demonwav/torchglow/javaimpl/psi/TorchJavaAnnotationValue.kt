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
import com.demonwav.torchglow.psi.TorchAnnotationValue
import com.intellij.psi.PsiNameValuePair

class TorchJavaAnnotationValue(
    override val annotation: TorchAnnotation,
    private val annotationValue: PsiNameValuePair
) : TorchJavaElement(annotationValue), TorchAnnotationValue {

    override val name: String?
        get() = annotationValue.name

    override val value: String?
        get() = annotationValue.value?.text
}
