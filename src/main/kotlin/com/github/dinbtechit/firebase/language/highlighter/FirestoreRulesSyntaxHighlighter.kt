package com.github.dinbtechit.firebase.language.highlighter



import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.BOOL_LITERAL
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.COMMENT
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.FUNCTION_NAME
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.KEYWORD
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.PATH_VARIABLE
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.SECONDARY_KEYWORD
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.STRING_LITERAL

import com.github.dinbtechit.firebase.language.parser.FirestoreRulesLexerAdapter
import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType


class FirestoreRulesSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer = FirestoreRulesLexerAdapter()

    override fun getTokenHighlights(elementType: IElementType?): Array<TextAttributesKey> {

        when (elementType) {
            FirestoreRulesTypes.LINE_COMMENT, FirestoreRulesTypes.BLOCK_COMMENT, FirestoreRulesTypes.RULES_VERSION -> {
                return array(COMMENT)
            }
            FirestoreRulesTypes.STRING_LITERAL -> return  array(STRING_LITERAL)
            FirestoreRulesTypes.PATH_VARIABLE_LITERAL, FirestoreRulesTypes.PATH_BUILT_IN_LITERAL -> {
                return  array(PATH_VARIABLE)
            }

            FirestoreRulesTypes.ALLOW, FirestoreRulesTypes.FUNCTION,
            FirestoreRulesTypes.MATCH, FirestoreRulesTypes.SERVICE, FirestoreRulesTypes.LET -> {
                return  array(KEYWORD)
            }

            FirestoreRulesTypes.IF, FirestoreRulesTypes.RETURN -> {
                return array(SECONDARY_KEYWORD)
            }

            /*FirestoreRulesTypes.WRITE, FirestoreRulesTypes.READ, FirestoreRulesTypes.GET,
            FirestoreRulesTypes.CREATE, FirestoreRulesTypes.LIST, FirestoreRulesTypes.DELETE,
            FirestoreRulesTypes.UPDATE -> {
                return array(TYPES)
            }*/

            FirestoreRulesTypes.BOOL_LITERAL -> return  array(BOOL_LITERAL)

            FirestoreRulesTypes.FUNCTION_NAME -> {
                return  array(FUNCTION_NAME)
            }
        }
        return arrayOf()
    }

    private fun array(attr: TextAttributesKey) = arrayOf(attr)
}