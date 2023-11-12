package com.github.dinbtechit.firebase.psi

import com.github.dinbtechit.firebase.psi.types.function.RuleFunctionNamedElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

object RulesPsiImplUtil {
    fun getFunctionName(element: RuleFunctionNamedElement): String? {
        val keyNode = element.getNode().findChildByType(FirestoreRulesTypes.FUNCTION_NAME)
        return keyNode?.text?.replace("\\\\ ", " ")
    }

    fun setName(element: RuleFunctionNamedElement, newName: String): PsiElement {
        val keyNode = element.getNode().findChildByType(FirestoreRulesTypes.FUNCTION_NAME)
        if (keyNode != null) {
            val property = RulesElementFactory.createFunction(element.project, newName)
            val newKeyNode: ASTNode = property.firstChild.node
            element.node.replaceChild(keyNode, newKeyNode)
        }
        return element
    }

    fun getNameIdentifier(element: RuleFunctionNamedElement): PsiElement? {
        return element.node.findChildByType(FirestoreRulesTypes.FUNCTION_NAME)?.psi
    }
}
