package com.github.dinbtechit.firebase.psi.types.function

import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiNameIdentifierOwner


interface RuleNamedElement : PsiNameIdentifierOwner
abstract class RuleNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
    RuleNamedElement

interface RuleFunctionNamedElement : RuleNamedElement {
    override fun getName(): String?
}

open class RuleFunctionNamedElementImpl(node: ASTNode): RuleNamedElementImpl(node), RuleFunctionNamedElement {
    override fun getName(): String? {
        return RulesPsiImplUtil.getFunctionName(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        visitor.visitElement(this)
    }

    override fun setName(p0: String): PsiElement {
        return RulesPsiImplUtil.setName(this, p0)
    }

    override fun getNameIdentifier(): PsiElement? {
        return RulesPsiImplUtil.getNameIdentifier(this)
    }

}



