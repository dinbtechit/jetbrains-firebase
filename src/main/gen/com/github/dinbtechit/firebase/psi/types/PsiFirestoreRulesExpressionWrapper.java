// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesExpressionWrapper extends PsiElement {

  @Nullable
  PsiFirestoreRulesArithmeticExpression getArithmeticExpression();

  @Nullable
  PsiFirestoreRulesBooleanExpression getBooleanExpression();

  @Nullable
  PsiFirestoreRulesLogicalExpression getLogicalExpression();

  @Nullable
  PsiFirestoreRulesTernaryExpression getTernaryExpression();

}
