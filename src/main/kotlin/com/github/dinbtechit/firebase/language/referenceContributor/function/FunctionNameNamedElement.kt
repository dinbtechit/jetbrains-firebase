package com.github.dinbtechit.firebase.language.referenceContributor.function

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

interface FirestoreFunctionNameNamedElement : PsiNamedElement, NavigatablePsiElement

open class FirestoreFunctionNameNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
    FirestoreFunctionNameNamedElement {

    override fun getName(): String? {
        return this.text
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

    /*override fun getReference(): PsiReference? {
        if (parent is PsiFirestoreRulesFunctionCall) {
            val rangeInElement = TextRange(0, node.textLength)
            return FirestoreFunctionReference(this, rangeInElement)
        }
        return null
    }*/

    override fun getReferences(): Array<PsiReference> {
        val rangeInElement = TextRange(0, node.textLength)
        return arrayOf(FirestoreFunctionReference(this, rangeInElement))
    }
}