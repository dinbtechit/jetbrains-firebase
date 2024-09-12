package com.github.dinbtechit.firebase.language.referenceContributor.provider

import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionReference
import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.github.dinbtechit.firebase.psi.RulesUtil
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

class RuleFunctionReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, p1: ProcessingContext): Array<out PsiReference> {
        val functionCalls = RulesUtil.findFunctionsByElementParent(element.containingFile)
        val references = mutableListOf<PsiReference>()
            for (functionCall in functionCalls) {
                val el = RulesPsiImplUtil.getNameIdentifier(functionCall)
                if (el != null) {
                    val textRange = TextRange(0, el.textLength)
                    val ref = FirestoreFunctionReference(functionCall, textRange)
                    references.add(ref)
                }
            }



        return if (references.isNotEmpty()) references.toTypedArray() else PsiReference.EMPTY_ARRAY
    }
}