package com.github.dinbtechit.firebase.language.color

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object FirestoreRulesTextAttributeKeys {
    val BOOL_LITERAL = createFireRuleAttributeKey("BOOLEAN_VARIABLE", DefaultLanguageHighlighterColors.KEYWORD)
    val COMMENT = createFireRuleAttributeKey("COMMENT", LINE_COMMENT)
    val FUNCTION_NAME = createFireRuleAttributeKey("FUNCTION_NAME", FUNCTION_DECLARATION)
    val LOCAL_VARIABLE = createFireRuleAttributeKey("LOCAL_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
    val SERVICE_NAME = createFireRuleAttributeKey("SERVICE_NAME", CLASS_NAME)
    val KEYWORD = createFireRuleAttributeKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    private val DEFAULT_SECONDARY_KEYWORD = createTextAttributesKey(
        "DEFAULT_SECONDARY_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
    )
    val PERMISSION_METHOD_TYPE = createFireRuleAttributeKey("PERMISSION_METHOD_TYPE", SERVICE_NAME)
    val PATH_VARIABLE = createFireRuleAttributeKey("PATH_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
    val SECONDARY_KEYWORD = createFireRuleAttributeKey("SECONDARY_KEYWORD", DEFAULT_SECONDARY_KEYWORD)
    val STRING_LITERAL = createFireRuleAttributeKey("STRING_LITERAL", STRING)
    val NUMBER_LITERAL = createFireRuleAttributeKey("NUMBER_LITERAL", NUMBER)

    private fun createFireRuleAttributeKey(keyNameSuffix: String, defaultHighlighterColors: TextAttributesKey) =
        createTextAttributesKey("FIRE_RULE_$keyNameSuffix", defaultHighlighterColors)
}