package com.github.dinbtechit.firebase.psi

import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionDeclarationNamedElement
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionBlock
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionName
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

object RulesPsiImplUtil {

    fun getFunctionName(element: PsiElement): String? {
        return when (element) {
            is PsiFirestoreRulesFunctionBlock -> {
                element.functionName?.text?.replace("\\\\ ", " ")
            }
            is PsiFirestoreRulesFunctionName -> {
                element.text?.replace("\\\\ ", " ")
            }
            else -> {
                val el = PsiTreeUtil.getChildOfType(element, PsiFirestoreRulesFunctionName::class.java)
                el?.text?.replace("\\\\ ", " ")
            }
        }
    }

    fun setName(element: FirestoreFunctionDeclarationNamedElement, newName: String): PsiElement {
        val keyNode = PsiTreeUtil.getChildOfType(element, PsiFirestoreRulesFunctionName::class.java)
       /* if (keyNode != null) {
            val property = RulesElementFactory.createFunction(element.project, newName)
            val newKeyNode: ASTNode = property.firstChild.node
            element.node.replaceChild(keyNode, newKeyNode)
        }*/
        //TODO implement
        return element
    }

    fun getNameIdentifier(element: PsiElement): PsiElement? {
        return when (element) {
            is PsiFirestoreRulesFunctionBlock -> {
                element.functionName
            }
            is PsiFirestoreRulesFunctionName -> {
                element
            }
            else -> {
                PsiTreeUtil.getChildOfType(element, PsiFirestoreRulesFunctionName::class.java)
            }
        }
    }
}
