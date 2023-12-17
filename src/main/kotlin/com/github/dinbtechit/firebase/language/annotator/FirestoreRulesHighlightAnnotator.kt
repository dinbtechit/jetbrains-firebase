package com.github.dinbtechit.firebase.language.annotator

import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.FUNCTION_NAME
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.LOCAL_VARIABLE
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.PERMISSION_METHOD_TYPE
import com.github.dinbtechit.firebase.language.color.FirestoreRulesTextAttributeKeys.SERVICE_NAME
import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesFunctionName
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesPermissionType
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesServiceName
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesVariableName
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class FirestoreRulesHighlightAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        var type = when (element.parent) {
            is PsiFirestoreRulesFunctionName -> FUNCTION_NAME
            is PsiFirestoreRulesPermissionType, is PsiFirestoreRulesServiceName -> PERMISSION_METHOD_TYPE
            is PsiFirestoreRulesVariableName -> LOCAL_VARIABLE
            else -> when(element) {
                is PsiFirestoreRulesServiceName -> SERVICE_NAME
                else -> null
            }
        }

        type = when (element.elementType) {
            FirestoreRulesTypes.PATH_VARIABLE_LITERAL -> LOCAL_VARIABLE
            else -> type
        }

        type ?: return // Simply returning when Type is null
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(element.textRange)
            .textAttributes(type)
            .create()
    }
}