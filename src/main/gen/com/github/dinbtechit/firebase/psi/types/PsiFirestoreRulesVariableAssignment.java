// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesVariableAssignment extends PsiElement {

  @Nullable
  PsiFirestoreRulesExpressionWrapper getExpressionWrapper();

  @Nullable
  PsiFirestoreRulesFunctionCallStmt getFunctionCallStmt();

  @NotNull
  List<PsiFirestoreRulesVariableName> getVariableNameList();

  @NotNull
  PsiElement getEq();

  @Nullable
  PsiElement getNumberLiteral();

  @Nullable
  PsiElement getSemicolon();

  @Nullable
  PsiElement getStringLiteral();

}
