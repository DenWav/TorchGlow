/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode PSI Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 */

package com.demonwav.torchglow.java

import com.demonwav.torchglow.TorchCache
import com.demonwav.torchglow.java.TorchJavaParser
import com.demonwav.torchglow.psi.TorchClass
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiClass
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.ParameterizedCachedValue
import com.intellij.psi.util.PsiModificationTracker

class TorchJavaCache(project: Project) : TorchCache<PsiClass>(project) {

    override fun getTorch(psi: PsiClass): TorchClass? {
        return CachedValuesManager.getManager(project).getParameterizedCachedValue(psi, KEY, this, true, psi)
    }

    override fun createResult(torch: TorchClass): CachedValueProvider.Result<TorchClass> {
        return CachedValueProvider.Result.createSingleDependency(torch, PsiModificationTracker.JAVA_STRUCTURE_MODIFICATION_COUNT)
    }

    override fun compute(param: PsiClass): CachedValueProvider.Result<TorchClass>? {
        return createResult(TorchJavaParser.buildStructure(param))
    }

    companion object : TorchCacheCompanion<TorchJavaCache>(::TorchJavaCache) {
        val KEY = Key.create<ParameterizedCachedValue<TorchClass, PsiClass>>("TorchJavaCache")
    }
}
