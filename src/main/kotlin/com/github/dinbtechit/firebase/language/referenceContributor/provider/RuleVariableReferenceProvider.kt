package com.github.dinbtechit.firebase.language.referenceContributor.provider

import com.github.dinbtechit.firebase.language.referenceContributor.variable.FirestoreVariableReference
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesVariableName
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

class RuleVariableReferenceProvider: PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, p1: ProcessingContext): Array<out PsiReference> {
        val refElements =  PsiTreeUtil.collectElementsOfType(element.containingFile, PsiFirestoreRulesVariableName::class.java)
        val references = mutableListOf<PsiReference>()

        for (functionCall in refElements) {
            val ref = FirestoreVariableReference(element)
            references.add(ref)
        }

        return if (references.isNotEmpty()) references.toTypedArray() else PsiReference.EMPTY_ARRAY
    }
}