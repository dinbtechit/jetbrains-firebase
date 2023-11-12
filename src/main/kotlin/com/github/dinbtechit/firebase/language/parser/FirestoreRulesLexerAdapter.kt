package com.github.dinbtechit.firebase.language.parser

import com.github.dinbtechit.firebase.grammar._RulesLexer
import com.intellij.lexer.FlexAdapter

class FirestoreRulesLexerAdapter: FlexAdapter(_RulesLexer(null)) {
}