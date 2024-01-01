package com.github.dinbtechit.firebase.language.referenceContributor

import com.github.dinbtechit.firebase.language.referenceContributor.provider.RuleFunctionReferenceProvider
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar

class RuleFunctionReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            psiElement(),
            RuleFunctionReferenceProvider()
        )

       /* registrar.registerReferenceProvider(
            psiElement(),
            RuleVariableReferenceProvider(), PsiReferenceRegistrar.HIGHER_PRIORITY
        )*/
    }
}