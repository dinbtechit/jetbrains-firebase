package com.github.dinbtechit.firebase.psi.types

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

class RuleTypeElement(debugName: String) : IElementType(debugName, FirestoreRulesLanguage.INSTANCE) {
}