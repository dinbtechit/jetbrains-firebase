package com.github.dinbtechit.firebase.psi.types.function

import com.github.dinbtechit.firebase.psi.RulesUtil
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class RuleNamedFunctionReference(element: PsiElement, textRange: TextRange)
    : PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference  {

    private var key: String = element.text.substring(textRange.startOffset, textRange.endOffset)
    override fun resolve(): PsiElement? {
        val resolveResult = multiResolve(false)
        return resolveResult.map { it.element }.firstOrNull()
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

    override fun getVariants(): Array<Any> {
       val project = myElement.project
        val functions: List<RuleFunctionNamedElement> = RulesUtil.findFunctions(project)
        val variants = mutableListOf<LookupElement>()
        functions.forEach {
            variants.add(LookupElementBuilder.create(it).withIcon(AllIcons.Nodes.Function))
        }
        return variants.toTypedArray()
    }
}