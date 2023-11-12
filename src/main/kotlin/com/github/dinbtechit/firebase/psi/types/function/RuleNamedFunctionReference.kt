package com.github.dinbtechit.firebase.psi.types.function

import com.github.dinbtechit.firebase.psi.RulesUtil
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult

class RuleNamedFunctionReference(element: RuleFunctionNamedElement, textRange: TextRange)
    : PsiReferenceBase<RuleFunctionNamedElement>(element, textRange), PsiPolyVariantReference  {

    private var key: String = element.text.substring(textRange.startOffset, textRange.endOffset)
    override fun resolve(): RuleFunctionNamedElement {
        val resolveResult = multiResolve(false)
        return resolveResult.map { it.element }.firstOrNull() as RuleFunctionNamedElement
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement.project
        val functions = RulesUtil.findFunctions(project, key)
        val results = mutableListOf<ResolveResult>()
        functions.forEach {
            results.add(PsiElementResolveResult(it))
        }
        if (results.isEmpty()) results.add(ResolveResult.EMPTY_ARRAY[0])
        return results.toTypedArray()
    }
}