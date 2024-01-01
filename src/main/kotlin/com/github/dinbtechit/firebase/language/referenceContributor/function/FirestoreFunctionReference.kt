package com.github.dinbtechit.firebase.language.referenceContributor.function

import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.github.dinbtechit.firebase.psi.RulesUtil
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class FirestoreFunctionReference(element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {

    //private var key: String = element.text.substring(textRange.startOffset, textRange.endOffset)

    private var key = ""

    init {
        key = RulesPsiImplUtil.getFunctionName(element) ?: ""
    }

    override fun resolve(): PsiElement? {
        val resolveResult = multiResolve(false)
        return resolveResult.map { it.element }.firstOrNull()
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val functions = RulesUtil.findFunctionsByElementParent(myElement, key)
        val results = mutableListOf<ResolveResult>()
        functions.forEach {
            results.add(PsiElementResolveResult(it))
        }
        return if (results.isNotEmpty())
            results.toTypedArray()
        else ResolveResult.EMPTY_ARRAY
    }


    override fun getVariants(): Array<Any> {
        val project = myElement.project
        val functions = RulesUtil.findFunctionsByElementParent(myElement)
        val variants = mutableListOf<Any>()
        functions.forEach {
                variants.add(
                    LookupElementBuilder.create(it.functionName?.text!!)
                        .withIcon(AllIcons.Nodes.Function)
                )

        }
        return variants.toTypedArray()
    }
}