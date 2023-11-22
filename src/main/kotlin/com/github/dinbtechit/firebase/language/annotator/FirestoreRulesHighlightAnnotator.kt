package com.github.dinbtechit.firebase.language.annotator

import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.FUNCTION_NAME
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.LOCAL_VARIABLE
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.PERMISSION_METHOD_TYPE
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.SERVICE_NAME
import com.github.dinbtechit.firebase.psi.types.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class FirestoreRulesHighlightAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val type = when (element.parent) {
            is PsiFirestoreRulesFunctionName -> FUNCTION_NAME
            is PsiFirestoreRulesPermissionType, is PsiFirestoreRulesServiceName -> PERMISSION_METHOD_TYPE
            is PsiFirestoreRulesVariableName -> LOCAL_VARIABLE
            is PsiFirestoreRulesObjectProperty -> LOCAL_VARIABLE
            else -> when(element) {
                is PsiFirestoreRulesServiceName -> SERVICE_NAME
                else -> null
            }
        }
        type ?: return // Simply returning when Type is null
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(element.textRange)
            .textAttributes(type)
            .create()
    }
}