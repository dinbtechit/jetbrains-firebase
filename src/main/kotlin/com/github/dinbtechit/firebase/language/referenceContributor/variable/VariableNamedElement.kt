package com.github.dinbtechit.firebase.language.referenceContributor.variable

import com.github.dinbtechit.firebase.psi.RulesUtil
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

interface FirestoreVariableNamedElement : PsiNameIdentifierOwner, NavigatablePsiElement
open class FirestoreVariableNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
    FirestoreVariableNamedElement {

    override fun getName(): String? {
        return this.text
    }

    override fun setName(p0: String): PsiElement {
       TODO("Implement setName")
    }

    override fun getReferences(): Array<PsiReference> {
            val rangeInElement = TextRange(0, node.textLength)
            return arrayOf(FirestoreVariableReference(this, rangeInElement))
    }

    override fun getNameIdentifier(): PsiElement? {
        return this
    }

}

class FirestoreVariableReference(private val element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {
    override fun resolve(): PsiElement? {
        val resolveResult = multiResolve(false)
        return resolveResult.map { it.element }.firstOrNull()
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val functions = RulesUtil.findVariables(element)
        val results = mutableListOf<ResolveResult>()
        functions.forEach {
            results.add(PsiElementResolveResult(it))
        }
        return if (results.isNotEmpty())
            results.toTypedArray()
        else ResolveResult.EMPTY_ARRAY
    }

    override fun getVariants(): Array<LookupElement> {
        val functions = RulesUtil.findVariables(element)
        val variants = mutableListOf<LookupElement>()
        functions.forEach {
            variants.add(
                LookupElementBuilder.create(it.text)
                    .withIcon(AllIcons.Nodes.Variable)
            )
        }

        return variants.toTypedArray()
    }
}