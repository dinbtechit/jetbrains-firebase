package com.github.dinbtechit.firebase.language

import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*
import com.intellij.psi.tree.TokenSet

object RulesTokenSets {

    val KEYWORDS = TokenSet.create(
        ALLOW, FUNCTION, MATCH, SERVICE, LET
    )
    
    val STRING = TokenSet.create(STRING_LITERAL)

    val SECONDARY_KEYWORDS = TokenSet.create(
        IF, RETURN
    )

    val COMMENT = TokenSet.create(
        BLOCK_COMMENT, LINE_COMMENT
    )

    val LITERALS = TokenSet.create(
       QUOTE, DOUBLE_QUOTE
    )

    val TYPE = TokenSet.create(
        GET, LIST, DELETE, READ, WRITE, UPDATE
    )
}