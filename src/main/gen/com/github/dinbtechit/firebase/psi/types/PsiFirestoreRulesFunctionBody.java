// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesFunctionBody extends PsiElement {

  @NotNull
  List<PsiFirestoreRulesCommentRule> getCommentRuleList();

  @NotNull
  List<PsiFirestoreRulesExpressionWrapperWithSemi> getExpressionWrapperWithSemiList();

  @NotNull
  List<PsiFirestoreRulesFunctionCallStmtWithSemi> getFunctionCallStmtWithSemiList();

  @NotNull
  List<PsiFirestoreRulesReturnStmt> getReturnStmtList();

  @NotNull
  List<PsiFirestoreRulesVariableAssignment> getVariableAssignmentList();

  @NotNull
  List<PsiFirestoreRulesVariableDeclaration> getVariableDeclarationList();

  @NotNull
  PsiElement getLBrace();

  @Nullable
  PsiElement getRBrace();

}
