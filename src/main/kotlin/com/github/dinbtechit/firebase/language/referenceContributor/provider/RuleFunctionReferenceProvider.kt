package com.github.dinbtechit.firebase.language.referenceContributor.provider

import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionReference
import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionBlock
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

class RuleFunctionReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, p1: ProcessingContext): Array<out PsiReference> {
        val functionCalls =
            PsiTreeUtil.collectElementsOfType(element.containingFile, PsiFirestoreRulesFunctionBlock::class.java)
        val references = mutableListOf<PsiReference>()
            for (functionCall in functionCalls) {
                val textRange = RulesPsiImplUtil.getNameIdentifier(functionCall)?.textRange
                if (textRange != null) {
                    val ref = FirestoreFunctionReference(element, textRange)
                    references.add(ref)
                }
            }



        return if (references.isNotEmpty()) references.toTypedArray() else PsiReference.EMPTY_ARRAY
    }
}