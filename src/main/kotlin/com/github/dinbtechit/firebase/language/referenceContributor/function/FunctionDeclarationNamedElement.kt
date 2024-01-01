package com.github.dinbtechit.firebase.language.referenceContributor.function

import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionBlock
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.suggested.startOffset


interface FirestoreFunctionDeclarationNamedElement : PsiNameIdentifierOwner, NavigatablePsiElement

open class FirestoreFunctionDeclarationNamedElementImpl(node: ASTNode): ASTWrapperPsiElement(node),
    FirestoreFunctionDeclarationNamedElement {
    override fun getName(): String? {
        return RulesPsiImplUtil.getFunctionName(this)
    }

    override fun getTextOffset(): Int {
        val element = RulesPsiImplUtil.getNameIdentifier(this)
        return element?.startOffset ?: super.getTextOffset()
    }

    override fun setName(p0: String): PsiElement {
        return RulesPsiImplUtil.setName(this, p0)
    }

    override fun getNameIdentifier(): PsiElement? {
        return RulesPsiImplUtil.getNameIdentifier(this)
    }

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



