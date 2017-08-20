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
import com.intellij.openapi.project.Project
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.ParameterizedCachedValueProvider
import java.util.concurrent.ConcurrentHashMap

abstract class TorchCache<T> protected constructor(protected val project: Project) : ParameterizedCachedValueProvider<TorchClass, T> {

    abstract fun getTorch(psi: T): TorchClass?
    abstract fun createResult(torch: TorchClass): CachedValueProvider.Result<TorchClass>

    abstract class TorchCacheCompanion<out C : TorchCache<*>>(private  val constructor: (Project) -> C) {
        private val map = ConcurrentHashMap<String, C>()

        fun getInstance(project: Project) = map.computeIfAbsent(project.locationHash) { constructor(project) }
    }
}
