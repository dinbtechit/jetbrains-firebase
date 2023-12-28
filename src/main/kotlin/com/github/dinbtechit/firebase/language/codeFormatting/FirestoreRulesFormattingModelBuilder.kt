package com.github.dinbtechit.firebase.language.codeFormatting

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.github.dinbtechit.firebase.language.RulesTokenSets
import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock


class FirestoreRulesFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val codeStyleSettings = formattingContext.codeStyleSettings
        val block = createCustomBlock(formattingContext.node, codeStyleSettings)
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile, block, codeStyleSettings
        )
    }

    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
        return SpacingBuilder(settings, FirestoreRulesLanguage.INSTANCE)
            .after(RulesTokenSets.KEYWORDS).spaces(1)
            .after(RulesTokenSets.SECONDARY_KEYWORDS).spaces(1)
            .after(FirestoreRulesTypes.L_BRACE).lineBreakInCode()
            .before(FirestoreRulesTypes.R_BRACE).lineBreakInCode()
            .before(FirestoreRulesTypes.L_BRACE).spaces(1)
            .before(FirestoreRulesTypes.COLON).spaces(0)
            .after(FirestoreRulesTypes.COLON).spaces(1)
            .after(FirestoreRulesTypes.SEMICOLON).lineBreakInCode()
            .around(FirestoreRulesTypes.SEMICOLON).spaces(0)
            //.around(TokenSet.create(FirestoreRulesTypes.VARIABLE_NAME)).spaces(0)
            .before(FirestoreRulesTypes.EQ).spaces(1)
            .after(FirestoreRulesTypes.EQ).spaces(1)

    }

    private fun createCustomBlock(node: ASTNode, codeStyleSettings: CodeStyleSettings): Block {
        return CodeBlock(
            node, codeStyleSettings, createSpaceBuilder(codeStyleSettings)
        )
    }
}

class CodeBlock(
    node: ASTNode, private val codeStyleSettings: CodeStyleSettings, private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment()) {

    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        return spacingBuilder.getSpacing(this, p0, p1)
    }

    override fun getIndent(): Indent? {
        return Indent.getNoneIndent()
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    // Defines when press enter -> New line when the intend should start
    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        return ChildAttributes(Indent.getNormalIndent(), null)
    }


    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        var child = myNode.firstChildNode
        while (child != null) {
            when {

                child.elementType == FirestoreRulesTypes.SERVICE_BLOCK -> {
                    blocks.add(CodeBlock(child, codeStyleSettings, spacingBuilder))
                }

                child.elementType == FirestoreRulesTypes.SERVICE_BODY -> {
                    for (ch in child.getChildren(null)) {
                        when (ch.elementType) {
                            FirestoreRulesTypes.FUNCTION_BLOCK, FirestoreRulesTypes.MATCH_BLOCK
                            -> blocks.add(InnerCodeBlock(ch, codeStyleSettings, spacingBuilder))

                            else -> {
                                if (ch.elementType !== TokenType.WHITE_SPACE) {
                                    val block: Block = if (ch.getChildren(null).size > 1) SimpleBlock(
                                        ch, codeStyleSettings, spacingBuilder
                                    ) else LeafBlock(
                                        ch, codeStyleSettings, spacingBuilder
                                    )
                                    blocks.add(block)
                                }
                            }
                        }
                    }
                }

                child.elementType == FirestoreRulesTypes.MATCH_BLOCK || child.elementType == FirestoreRulesTypes.FUNCTION_BLOCK -> {
                    blocks.add(CodeBlock(child, codeStyleSettings, spacingBuilder))
                }

                else -> {
                    if (child.elementType !== TokenType.WHITE_SPACE) {
                        val block: Block = if (child.getChildren(null).size > 1) SimpleBlock(
                            child, codeStyleSettings, spacingBuilder
                        ) else LeafBlock(
                            child, codeStyleSettings, spacingBuilder
                        )
                        blocks.add(block)
                    }
                }
            }
            child = child.treeNext
        }
        return blocks
    }
}

class InnerCodeBlock(
    node: ASTNode, private val codeStyleSettings: CodeStyleSettings, private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment()) {

    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        if (p0 is SimpleBlock && p1 is SimpleBlock) {
            return spacingBuilder.after(FirestoreRulesTypes.SEMICOLON).lineBreakInCode()
                .getSpacing(this, p0, p1)
        }
        return spacingBuilder.getSpacing(this, p0, p1)
    }

    override fun getIndent(): Indent? {
        return Indent.getNormalIndent()
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        return ChildAttributes(Indent.getNormalIndent(), null)
    }

    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        var child = myNode.firstChildNode
        while (child != null) {
            when {
                child.elementType == FirestoreRulesTypes.SERVICE_BODY
                        || child.elementType == FirestoreRulesTypes.FUNCTION_BODY
                        || child.elementType == FirestoreRulesTypes.MATCH_BODY -> {
                    for (ch in child.getChildren(null)) {
                        when (ch.elementType) {
                            FirestoreRulesTypes.FUNCTION_BLOCK
                            -> blocks.add(InnerCodeBlock(ch, codeStyleSettings, spacingBuilder))

                            else -> {
                                if (ch.elementType !== TokenType.WHITE_SPACE) {
                                    val block: Block = if (ch.getChildren(null).size > 1) SimpleBlock(
                                        ch, codeStyleSettings, spacingBuilder
                                    ) else LeafBlock(
                                        ch, codeStyleSettings, spacingBuilder
                                    )
                                    blocks.add(block)
                                }
                            }
                        }
                    }
                }

                else -> {
                    if (child.elementType !== TokenType.WHITE_SPACE) {
                        val block: Block = if (child.getChildren(null).size > 1) SimpleBlock(
                            child, codeStyleSettings, spacingBuilder
                        ) else LeafBlock(
                            child, codeStyleSettings, spacingBuilder
                        )
                        blocks.add(block)
                    }
                }
            }
            child = child.treeNext
        }
        return blocks
    }
}

class SimpleBlock(
    node: ASTNode, private val codeStyleSettings: CodeStyleSettings, private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment()) {
    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        return spacingBuilder.getSpacing(this, p0, p1)
    }

    override fun getIndent(): Indent? {
        for (block in subBlocks) {
            if (myNode.elementType == FirestoreRulesTypes.VERSION_DEF) {
                return Indent.getNoneIndent()
            }
        }
        return Indent.getNormalIndent()
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        var child = myNode.firstChildNode
        while (child != null) {
            when {
                child.getChildren(null).size > 1 -> {
                    blocks.add(
                        SimpleBlock(
                            child, codeStyleSettings, spacingBuilder
                        )
                    )
                }

                else -> {
                    if (child.elementType !== TokenType.WHITE_SPACE) {
                        val block: Block = LeafBlock(
                            child, codeStyleSettings, spacingBuilder
                        )
                        blocks.add(block)
                    }
                }
            }
            child = child.treeNext
        }
        return blocks

    }
}

class LeafBlock(
    node: ASTNode, private val codeStyleSettings: CodeStyleSettings, private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment()) {
    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        return spacingBuilder.getSpacing(this, p0, p1)
    }

    override fun getIndent(): Indent? {
        return Indent.getNoneIndent()
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    override fun buildChildren(): MutableList<Block> = mutableListOf<Block>()
}


