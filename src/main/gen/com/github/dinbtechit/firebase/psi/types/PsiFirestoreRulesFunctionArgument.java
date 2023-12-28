// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesFunctionArgument extends PsiElement {

  @Nullable
  PsiFirestoreRulesExpressionWrapper getExpressionWrapper();

  @Nullable
  PsiFirestoreRulesFunctionCallStmt getFunctionCallStmt();

  @Nullable
  PsiFirestoreRulesJsonArray getJsonArray();

  @Nullable
  PsiFirestoreRulesJsonObject getJsonObject();

  @Nullable
  PsiFirestoreRulesObject getObject();

  @Nullable
  PsiFirestoreRulesVariableName getVariableName();

  @Nullable
  PsiElement getBoolLiteral();

  @Nullable
  PsiElement getNullLiteral();

  @Nullable
  PsiElement getNumberLiteral();

  @Nullable
  PsiElement getStringLiteral();

}
