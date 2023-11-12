package com.github.dinbtechit.firebase.psi

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.intellij.psi.tree.IElementType


open class RulesTokenType(debugName: String) : IElementType(debugName, FirestoreRulesLanguage.INSTANCE) {

    override fun toString(): String {
        return "RulesTokenType." + super.toString()
    }
}