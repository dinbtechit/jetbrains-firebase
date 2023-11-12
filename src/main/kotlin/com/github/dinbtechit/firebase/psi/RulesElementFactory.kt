package com.github.dinbtechit.firebase.psi

import com.github.dinbtechit.firebase.language.fileType.FirestoreFileType
import com.github.dinbtechit.firebase.language.fileType.RulesFile
import com.github.dinbtechit.firebase.psi.types.function.RuleFunctionNamedElement
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object RulesElementFactory {
    fun createFunction(project: Project, functionName: String): RuleFunctionNamedElement {
        val functionText = """
            function $functionName() {
              // TODO
            }
        """.trimIndent()
        val file = createFile(project, functionText)
        return file.firstChild as RuleFunctionNamedElement
    }

    fun createFile(project: Project, text: String): RulesFile {
        val name = "firestore.rules"
        return PsiFileFactory.getInstance(project)
            .createFileFromText(name, FirestoreFileType.INSTANCE, text) as RulesFile
    }
}