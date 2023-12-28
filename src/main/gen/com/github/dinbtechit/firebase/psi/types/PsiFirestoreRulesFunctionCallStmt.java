// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesFunctionCallStmt extends PsiElement {

  @Nullable
  PsiFirestoreRulesFunctionArgumentList getFunctionArgumentList();

  @NotNull
  PsiFirestoreRulesFunctionName getFunctionName();

  @Nullable
  PsiFirestoreRulesReturnVariable getReturnVariable();

  @NotNull
  PsiElement getLParen();

  @NotNull
  PsiElement getRParen();

}
