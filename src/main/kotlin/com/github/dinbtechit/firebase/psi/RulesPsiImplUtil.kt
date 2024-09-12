package com.github.dinbtechit.firebase.psi

import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionReference
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionBlock
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionName
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesIfLogic
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
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
                val el = PsiTreeUtil.findChildrenOfType(element, PsiFirestoreRulesFunctionName::class.java).firstOrNull()
                el?.text?.replace("\\\\ ", " ")
            }
        }
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
                PsiTreeUtil.findChildrenOfType(element, PsiFirestoreRulesFunctionName::class.java).firstOrNull()
            }
        }
    }
    @JvmStatic
    fun getReference(referenceExpr: PsiElement): PsiReference? {
        println("functionCall - GetReference")
        val functionDeclaration = RulesUtil.findFunctionsByElementParent(referenceExpr.containingFile)
        val references = mutableListOf<PsiReference>()

        for (declaration in functionDeclaration) {
            val textRange = RulesPsiImplUtil.getNameIdentifier(declaration)?.textRange
            val functionDecl = RulesPsiImplUtil.getNameIdentifier(declaration)
            if (textRange != null && functionDecl is PsiFirestoreRulesFunctionName) {
                val ref = FirestoreFunctionReference(functionDecl, functionDecl.textRange)
                references.add(ref)
            }
        }

        return references.toTypedArray().firstOrNull()
        //return PsiReferenceService.getService().getContributedReferences(this)
    }

    @JvmStatic
    fun getReferences(referenceExpr: PsiFirestoreRulesIfLogic): Array<PsiReference> {
        val functionCalls = RulesUtil.findFunctionsByElementParent(referenceExpr.containingFile)
        val references = mutableListOf<PsiReference>()

        for (functionCall in functionCalls) {
            val el = RulesPsiImplUtil.getNameIdentifier(functionCall)
            val textRange = RulesPsiImplUtil.getNameIdentifier(functionCall)?.textRange
            if (textRange != null && el is PsiFirestoreRulesFunctionName) {
                val ref = FirestoreFunctionReference(el, el.textRange)
                references.add(ref)
            }
        }

        return if (references.isNotEmpty()) references.toTypedArray() else PsiReference.EMPTY_ARRAY
        //return PsiReferenceService.getService().getContributedReferences(this)
    }
}
