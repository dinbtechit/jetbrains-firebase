package com.github.dinbtechit.firebase.psi.types

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.github.dinbtechit.firebase.psi.RulesElementTypes
import com.github.dinbtechit.firebase.psi.RulesTokenType
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

class RuleBlockCommentElement(debugName: String) : RulesTokenType(debugName) {
}