package com.github.dinbtechit.firebase.language.fileType

import com.github.dinbtechit.firebase.language.FirestoreRulesLanguage
import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class FirestoreFileType: LanguageFileType(FirestoreRulesLanguage.INSTANCE) {

    companion object {
        val INSTANCE = FirestoreFileType()
    }

    override fun getName(): String {
        return "FirestoreRules"
    }

    override fun getDescription(): String {
        return "Firestore rules file"
    }

    override fun getDefaultExtension(): String {
        return "rules"
    }

    override fun getIcon(): Icon {
        return AllIcons.FileTypes.Any_type // TODO Change to firebase icon
    }
}