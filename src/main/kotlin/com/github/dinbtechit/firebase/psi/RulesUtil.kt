package com.github.dinbtechit.firebase.psi
import com.github.dinbtechit.firebase.language.fileType.FirestoreFileType
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionBlock
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionName
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesVariableName
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

object RulesUtil {

    fun findFunctionsByElementParent(element: PsiElement, functionName: String? = null): MutableList<PsiFirestoreRulesFunctionBlock> {
        val result = mutableListOf<PsiFirestoreRulesFunctionBlock>()
        val functionBlocks: Collection<PsiFirestoreRulesFunctionBlock> =
            PsiTreeUtil.collectElementsOfType(element.containingFile, PsiFirestoreRulesFunctionBlock::class.java)
        result.addAll(functionBlocks)
        return result
    }

    fun findFunctions(element: PsiElement, functionName: String? = null): List<PsiFirestoreRulesFunctionName> {
        val result = mutableListOf<PsiFirestoreRulesFunctionName>()
        val functionBlocks =
            PsiTreeUtil.collectElementsOfType(element.containingFile, PsiFirestoreRulesFunctionName::class.java)
        result.addAll(functionBlocks)
        return result
    }

    fun findVariables(element: PsiElement, variableName: String? = null): List<PsiElement> {
        val result = mutableListOf<PsiElement>()
        val blocks =
            PsiTreeUtil.collectElementsOfType(element.containingFile, PsiFirestoreRulesVariableName::class.java)
        result.addAll(blocks)
        return result
    }

    fun findFunctions(project: Project, functionName: String? = null): List<PsiFirestoreRulesFunctionName> {
        val result = mutableListOf<PsiFirestoreRulesFunctionName>()
        val virtualFiles = FileTypeIndex.getFiles(FirestoreFileType.INSTANCE, GlobalSearchScope.allScope(project))
        for(virtualFile in virtualFiles) {
            val rulesFile = PsiManager.getInstance(project).findFile(virtualFile)
            if (rulesFile != null) {
                val functions = PsiTreeUtil.findChildrenOfType(rulesFile, PsiFirestoreRulesFunctionName::class.java)
                if (functions != null) {
                    if (functionName == null) {
                       result.addAll(functions)
                    } else {
                        result.addAll(functions.filter { it.text == functionName })
                    }
                }
            }
        }
        return result
    }
}