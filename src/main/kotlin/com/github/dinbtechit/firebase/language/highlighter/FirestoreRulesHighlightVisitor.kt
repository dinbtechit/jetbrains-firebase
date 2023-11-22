package com.github.dinbtechit.firebase.language.highlighter

import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.FUNCTION_NAME
import com.github.dinbtechit.firebase.language.fileType.FirestoreFileType
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesBindMethod
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesRulesMethod
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class FirestoreRulesHighlightVisitor : HighlightVisitor {

    private var highlightHolder: HighlightInfoHolder? = null

    override fun suitableForFile(psiFile: PsiFile): Boolean {
        return psiFile.fileType is FirestoreFileType
    }

    override fun visit(element: PsiElement) {
        if (highlightHolder == null) return
        when {
            element.parent is PsiFirestoreRulesRulesMethod
                    && ("get" in element.text
                    || "getAfter" in element.text
                    || "exists" in element.text
                    || "existsAfter" in element.text) -> {
                highlightHolder!!.add(createInfoHighlight(element.node, FUNCTION_NAME))
            }

            element.parent is PsiFirestoreRulesBindMethod
                    && "bind" in element.text -> {
                highlightHolder!!.add(createInfoHighlight(element.node, FUNCTION_NAME))
            }
        }
    }

    private fun createInfoHighlight(
        node: ASTNode,
        textAttributesKey: TextAttributesKey,
    ): HighlightInfo? {
        with(node.textRange) {
            return HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
                .range(this)
                .textAttributes(textAttributesKey)
                .severity(HighlightSeverity.INFORMATION)
                .create()
        }
    }

    override fun analyze(
        psiFile: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        highlightHolder = holder
        try {
            action.run()
        } catch (_: Throwable) {
        } finally {
            highlightHolder = null
        }
        return true
    }

    override fun clone(): HighlightVisitor {
        return FirestoreRulesHighlightVisitor()
    }
}