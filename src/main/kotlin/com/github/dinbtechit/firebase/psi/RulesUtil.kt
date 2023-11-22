package com.github.dinbtechit.firebase.psi
import com.github.dinbtechit.firebase.language.fileType.FirestoreFileType
import com.github.dinbtechit.firebase.psi.types.function.RuleFunctionNamedElement
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

object RulesUtil {
    fun findFunctions(project: Project, functionName: String? = null): List<RuleFunctionNamedElement> {
        val result = mutableListOf<RuleFunctionNamedElement>()
        val virtualFiles = FileTypeIndex.getFiles(FirestoreFileType.INSTANCE, GlobalSearchScope.allScope(project))
        for(virtualFile in virtualFiles) {
            val rulesFile = PsiManager.getInstance(project).findFile(virtualFile)
            if (rulesFile != null) {
                val functions = PsiTreeUtil.getChildrenOfType(rulesFile, RuleFunctionNamedElement::class.java)
                if (functions != null) {
                    if (functionName == null) {
                       result.addAll(functions)
                    } else {
                        result.addAll(functions.filter { it.getName() == functionName })
                    }
                }
            }
        }
        return result
    }
}