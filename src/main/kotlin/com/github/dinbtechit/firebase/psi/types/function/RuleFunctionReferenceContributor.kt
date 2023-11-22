package com.github.dinbtechit.firebase.psi.types.function

import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionName
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

class RuleFunctionReferenceContributor: PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(FirestoreRulesTypes.IDENTIFIER),
            object: PsiReferenceProvider() {
            override fun getReferencesByElement(element: PsiElement, p1: ProcessingContext): Array<PsiReference> {
                val functionCall =  PsiTreeUtil.getChildrenOfType(element, PsiFirestoreRulesFunctionName::class.java)?.firstOrNull()
                if (functionCall != null) {

                    PsiReference.ARRAY_FACTORY.create(0)[0] =
                        RuleNamedFunctionReference(element, functionCall.textRange)
                }
                return PsiReference.EMPTY_ARRAY
            }

        })
    }
}