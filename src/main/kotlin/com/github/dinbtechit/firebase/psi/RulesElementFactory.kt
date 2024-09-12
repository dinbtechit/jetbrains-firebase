package com.github.dinbtechit.firebase.psi

import com.github.dinbtechit.firebase.language.fileType.FirestoreFileType
import com.github.dinbtechit.firebase.language.fileType.RulesFile
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object RulesElementFactory {

    fun createFile(project: Project, text: String): RulesFile {
        val name = "dummy.rules"
        return PsiFileFactory.getInstance(project)
            .createFileFromText(name, FirestoreFileType.INSTANCE, text) as RulesFile
    }
}