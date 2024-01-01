package com.github.dinbtechit.firebase.language.referenceContributor.variable

import com.github.dinbtechit.firebase.psi.RulesUtil
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesVariableName
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil

interface FirestoreVariableNamedElement : PsiNameIdentifierOwner
open class FirestoreVariableNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), FirestoreVariableNamedElement,
    ContributedReferenceHost {

    override fun getName(): String? {
        return this.text
    }

    override fun setName(p0: String): PsiElement {
        //val keyNode = PsiTreeUtil.getChildOfType(this, PsiFirestoreRulesVariableName::class.java)
        //TODO Set name
        return this.copy()
    }

    override fun getReferences(): Array<PsiReference> {
        val functionCalls =
            PsiTreeUtil.collectElementsOfType(this.containingFile, PsiFirestoreRulesVariableName::class.java)
        val references = mutableListOf<PsiReference>()

        for (functionCall in functionCalls) {
            val ref = FirestoreVariableReference(functionCall)
            references.add(ref)
        }
        return if (references.isNotEmpty()) references.toTypedArray() else PsiReference.EMPTY_ARRAY
        //return PsiReferenceService.getService().getContributedReferences(this)
        //return PsiReference.EMPTY_ARRAY
    }

    override fun getNameIdentifier(): PsiElement? {
        return this
    }

}

class FirestoreVariableReference(private val element: PsiElement) :
    PsiReferenceBase<PsiElement>(element, element.textRange), PsiPolyVariantReference {
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
        variants.add(
            LookupElementBuilder.create("Variable Test")
                .withIcon(AllIcons.Nodes.Variable)
        )
        functions.forEach {
            variants.add(
                LookupElementBuilder.create(it.text)
                    .withIcon(AllIcons.Nodes.Variable)
            )
        }

        return variants.toTypedArray()
    }
}