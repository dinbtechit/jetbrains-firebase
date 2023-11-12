package com.github.dinbtechit.firebase.language.fileType

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class RulesFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FirestoreRulesLanguage.INSTANCE) {
    override fun getFileType(): FileType = FirestoreFileType.INSTANCE
    override fun toString(): String = "FireStoreRulesFile"
}