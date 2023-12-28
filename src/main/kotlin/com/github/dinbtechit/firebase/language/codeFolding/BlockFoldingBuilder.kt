package com.github.dinbtechit.firebase.language.codeFolding

import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class BlockFoldingBuilder: FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()
        appendDescriptors(root, document, descriptors)
        return descriptors.toTypedArray()
    }

    private fun appendDescriptors(psiElement: PsiElement, document: Document, descriptors: MutableList<FoldingDescriptor>) {
        if (psiElement.elementType == FirestoreRulesTypes.MATCH_BODY
            || psiElement.elementType == FirestoreRulesTypes.FUNCTION_BODY
            || psiElement.elementType == FirestoreRulesTypes.SERVICE_BODY) {
            descriptors.add(FoldingDescriptor(psiElement.node, psiElement.textRange))
        }

        // recursive call for children
        for (child in psiElement.children) {
            appendDescriptors(child, document, descriptors)
        }
    }

    override fun getPlaceholderText(p0: ASTNode): String {
        return "{...}"
    }

    override fun isCollapsedByDefault(p0: ASTNode): Boolean {
        return false
    }
}