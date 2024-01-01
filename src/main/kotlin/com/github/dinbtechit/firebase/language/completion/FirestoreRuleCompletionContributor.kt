package com.github.dinbtechit.firebase.language.completion

import com.github.dinbtechit.firebase.language.fileType.RulesFile
import com.github.dinbtechit.firebase.psi.FirestoreRulesTypes
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesPermissionType
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesPermissions
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesServiceBlock
import com.github.dinbtechit.firebase.psi.types.PsiFirestoreRulesVersionDef
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PlatformPatterns.psiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

class FirestoreRuleCompletionContributor : CompletionContributor() {

    init {

        extend(CompletionType.BASIC,
            psiElement(),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    println(parameters.position.toString())
                    println(parameters.position.parent.toString())
                    println(parameters.position.parent.parent.toString())
                    println(parameters.position.parent.parent.parent.toString())
                }
            }
        )


        extend(CompletionType.BASIC,
            psiElement().withParent(psiFile(RulesFile::class.java)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {

                    val par = PsiTreeUtil.getParentOfType(
                        parameters.originalPosition,
                        PsiFirestoreRulesServiceBlock::class.java
                    )

                    if (par == null) {
                        resultSet.addElement(LookupElementBuilder.create("service"))
                        val isRulesExist = PsiTreeUtil.collectElementsOfType(
                            parameters.originalFile.firstChild,
                            PsiFirestoreRulesVersionDef::class.java
                        ).firstOrNull()
                        if (isRulesExist == null) {
                            resultSet.addElement(LookupElementBuilder.create("rules_version"))
                        }
                    }
                }
            })

        extend(CompletionType.BASIC,
            psiElement().inside(psiElement(FirestoreRulesTypes.SERVICE_BODY))
                .and(
                    psiElement().andNot(
                        psiElement().inside(psiElement(FirestoreRulesTypes.FUNCTION_BLOCK)),
                    ).andNot(psiElement().inside(psiElement(FirestoreRulesTypes.MATCH_BLOCK)))
                ),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("match"))
                    resultSet.addElement(LookupElementBuilder.create("function"))

                }
            })

        extend(CompletionType.BASIC,
            psiElement().withSuperParent(2, psiElement(FirestoreRulesTypes.FUNCTION_BODY)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("let"))
                    resultSet.addElement(LookupElementBuilder.create("return"))

                }
            })

        extend(CompletionType.BASIC,
            psiElement().andOr(
                psiElement().inside(psiElement(FirestoreRulesTypes.MATCH_BODY)).and(
                    psiElement().afterLeaf("{")
                )
                    .andNot(
                        psiElement().andOr(
                            psiElement().inside(psiElement(FirestoreRulesTypes.ALLOW_BLOCK)),
                            psiElement().inside(psiElement(FirestoreRulesTypes.FUNCTION_BODY))
                        )
                    ),
            )
            ,
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("allow"))
                    resultSet.addElement(LookupElementBuilder.create("match"))
                    resultSet.addElement(LookupElementBuilder.create("function"))
                }
            })

        extend(CompletionType.BASIC,
            psiElement().withSuperParent(2, psiElement(FirestoreRulesTypes.MATCH_BODY)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("allow"))
                    resultSet.addElement(LookupElementBuilder.create("match"))
                    resultSet.addElement(LookupElementBuilder.create("function"))
                }
            })

        extend(CompletionType.BASIC,
            psiElement().andOr(
                psiElement().afterLeaf(psiElement(FirestoreRulesTypes.ALLOW)),
                psiElement().afterLeaf(
                    psiElement().withText(",")
                        .withSuperParent(2, psiElement(FirestoreRulesTypes.ALLOW_BLOCK))
                )
            ),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    var permissionTypes = mutableListOf("get", "write", "read", "create", "list", "delete", "update")
                    if (PsiTreeUtil.prevVisibleLeaf(parameters.position) is PsiFirestoreRulesPermissions
                        || PsiTreeUtil.prevVisibleLeaf(parameters.position)?.parent is PsiFirestoreRulesPermissions
                    ) {
                        val permissions =
                            PsiTreeUtil.prevVisibleLeaf(parameters.position)?.parent?.children?.filterIsInstance<PsiFirestoreRulesPermissionType>()
                                ?.map { it.text }
                        permissionTypes = permissionTypes.filter { !(permissions != null && permissions.contains(it)) }
                            .toMutableList()
                    }
                    for (permission in permissionTypes) {
                        resultSet.addElement(LookupElementBuilder.create(permission))
                    }

                }
            })

        extend(CompletionType.BASIC,
            psiElement(FirestoreRulesTypes.IDENTIFIER)
                .afterLeaf(psiElement(FirestoreRulesTypes.SERVICE)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext, resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("cloud.firestore"))
                    resultSet.addElement(LookupElementBuilder.create("firebase.storage"))
                }
            })
    }
}