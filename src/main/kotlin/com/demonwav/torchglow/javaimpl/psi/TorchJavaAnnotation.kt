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
import com.intellij.psi.PsiAnnotation

class TorchJavaAnnotation(private val annotation: PsiAnnotation) : TorchJavaElement(annotation), TorchAnnotation {

    override val values: Set<TorchAnnotationValue> by lazy {
        annotation.parameterList.attributes.mapTo(HashSet()) { TorchJavaAnnotationValue(this, it) }
    }
}
