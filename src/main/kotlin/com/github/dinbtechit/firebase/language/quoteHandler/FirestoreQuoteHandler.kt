package com.github.dinbtechit.firebase.language.quoteHandler

import com.github.dinbtechit.firebase.language.RulesTokenSets
import com.intellij.codeInsight.editorActions.QuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator

class FirestoreQuoteHandler: QuoteHandler {
    private val literalTokens = RulesTokenSets.LITERALS

    override fun isClosingQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        val tokenType = iterator.tokenType
        if(literalTokens.contains(tokenType)) {
           val start = iterator.start
           val end = iterator.end
           return end - start >= 1 && offset == end - 1
        }
        return false
    }

    override fun isOpeningQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        if (literalTokens.contains(iterator.tokenType)) {
            val start = iterator.start
            return offset == start
        }
        return false
    }

    override fun hasNonClosedLiteral(editor: Editor?, iterator: HighlighterIterator, offset: Int): Boolean {
        val start: Int = iterator.start
        try {
            val doc = editor!!.document
            val chars: CharSequence = doc.charsSequence
            val lineEnd: Int = doc.getLineEndOffset(doc.getLineNumber(offset))

            while (!iterator.atEnd() && iterator.start < lineEnd) {
                val tokenType = iterator.tokenType

                if (literalTokens.contains(tokenType)) {
                    if (isNonClosedLiteral(iterator, chars)) return true
                }
                iterator.advance()
            }
        } finally {
            while (iterator.atEnd() || iterator.start != start) iterator.retreat()
        }

        return false
    }

    private fun isNonClosedLiteral(iterator: HighlighterIterator, chars: CharSequence): Boolean {
        return iterator.start >= iterator.end - 1 ||
                chars[iterator.end - 1] != '\"' && chars[iterator.end - 1] != '\''
    }

    override fun isInsideLiteral(iterator: HighlighterIterator): Boolean {
        return literalTokens.contains(iterator.tokenType)
    }
}