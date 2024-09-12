package com.github.dinbtechit.firebase.language.referenceContributor.function

import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.github.dinbtechit.firebase.psi.RulesUtil
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class FirestoreFunctionReference(element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {

    override fun resolve(): PsiElement? {
        val resolveResult = multiResolve(true)
        return resolveResult.firstOrNull { it.element?.text == element.text }?.element
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val functions = RulesUtil.findFunctions(myElement, element.text)
        val results = mutableListOf<ResolveResult>()
        functions.forEach {
            val f = RulesPsiImplUtil.getNameIdentifier(it)
            if (f != null) {
                results.add(PsiElementResolveResult(f))
            }
        }
        return if (results.isNotEmpty())
            results.toTypedArray()
        else ResolveResult.EMPTY_ARRAY
    }


    override fun getVariants(): Array<Any> {
        val project = myElement.project
        val functions = RulesUtil.findFunctions(myElement)
        val variants = mutableListOf<Any>()
        functions.forEach {
                variants.add(
                    LookupElementBuilder.create(it.text!!)
                        .withIcon(AllIcons.Nodes.Function)
                )

        }
        return variants.toTypedArray()
    }
}