package com.github.dinbtechit.firebase.language.referenceContributor.function

import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionBlock
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil

interface FirestoreFunctionCallNamedElement : PsiNamedElement, NavigatablePsiElement

open class FirestoreFunctionCallNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
    FirestoreFunctionCallNamedElement {

    override fun getName(): String? {
        return RulesPsiImplUtil.getFunctionName(this)
    }

    override fun setName(p0: String): PsiElement {
        TODO("Not yet implemented")
    }


    /*override fun getReference(): PsiReference? {
        val functionName = PsiTreeUtil.getChildOfType(this, PsiFirestoreRulesFunctionName::class.java)
        val functionCall =
            PsiTreeUtil.collectElementsOfType(this.containingFile, PsiFirestoreRulesFunctionBlock::class.java)
                .firstOrNull { it.functionName?.text == functionName?.text }
        if (functionCall != null) {
            val functionNameFromBlock = RulesPsiImplUtil.getNameIdentifier(functionCall)
            return FirestoreFunctionReference(functionCall, functionNameFromBlock?.textRange!!)
        }

        return null
    }*/

    override fun getReferences(): Array<PsiReference> {
        val functionCalls =
            PsiTreeUtil.collectElementsOfType(this.containingFile, PsiFirestoreRulesFunctionBlock::class.java)
        val references = mutableListOf<PsiReference>()

        for (functionCall in functionCalls) {
            val textRange = RulesPsiImplUtil.getNameIdentifier(functionCall)?.textRange
            if (textRange != null) {
                val ref = FirestoreFunctionReference(functionCall, textRange)
                references.add(ref)
            }
        }

        return if (references.isNotEmpty()) references.toTypedArray() else PsiReference.EMPTY_ARRAY
        //return PsiReferenceService.getService().getContributedReferences(this)
    }
}