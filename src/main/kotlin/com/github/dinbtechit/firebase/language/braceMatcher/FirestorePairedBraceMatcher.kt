package com.github.dinbtechit.firebase.language.braceMatcher

import com.github.dinbtechit.firebase.language.RulesTokenSets
import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class FirestorePairedBraceMatcher : PairedBraceMatcher {

    private val bracePair = arrayOf(
        BracePair(FirestoreRulesTypes.L_BRACE, FirestoreRulesTypes.R_BRACE, true),
        BracePair(FirestoreRulesTypes.L_PAREN, FirestoreRulesTypes.R_PAREN, false),
        BracePair(FirestoreRulesTypes.L_BRACK, FirestoreRulesTypes.R_BRACK, false),
    )

    override fun getPairs(): Array<BracePair> {
       return bracePair
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return !RulesTokenSets.STRING.contains(contextType) &&
                contextType != FirestoreRulesTypes.L_BRACE &&
                contextType != FirestoreRulesTypes.L_BRACK &&
                contextType != FirestoreRulesTypes.L_PAREN
    }

    override fun getCodeConstructStart(psiFile: PsiFile, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}