package com.github.dinbtechit.firebase.psi.types.function

import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionCallExpression
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class RuleFunctionReferenceContributor: PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiFirestoreRulesFunctionCallExpression::class.java),
            object: PsiReferenceProvider() {
            override fun getReferencesByElement(element: PsiElement, p1: ProcessingContext): Array<PsiReference> {
                val functionCall =  element
                return PsiReference.EMPTY_ARRAY
            }

        })
    }
}