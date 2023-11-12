package com.github.dinbtechit.firebase.language.parser

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.github.dinbtechit.firebase.language.fileType.RulesFile
import com.github.dinbtechit.firebase.language.RulesTokenSets
import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class RulesParserDefinition : ParserDefinition {
    companion object {
        val FILE = IFileElementType(FirestoreRulesLanguage.INSTANCE)
    }
    override fun createLexer(p0: Project?): Lexer = FirestoreRulesLexerAdapter()

    override fun createParser(p0: Project?): PsiParser = RulesParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = RulesTokenSets.COMMENT
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
    override fun createElement(node: ASTNode?): PsiElement = FirestoreRulesTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = RulesFile(viewProvider)
}