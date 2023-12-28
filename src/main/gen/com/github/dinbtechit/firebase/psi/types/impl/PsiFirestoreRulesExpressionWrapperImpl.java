// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dinbtechit.firebase.psi.types.*;

public class PsiFirestoreRulesExpressionWrapperImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesExpressionWrapper {

  public PsiFirestoreRulesExpressionWrapperImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitExpressionWrapper(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesArithmeticExpression getArithmeticExpression() {
    return findChildByClass(PsiFirestoreRulesArithmeticExpression.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesBooleanExpression getBooleanExpression() {
    return findChildByClass(PsiFirestoreRulesBooleanExpression.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesLogicalExpression getLogicalExpression() {
    return findChildByClass(PsiFirestoreRulesLogicalExpression.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesTernaryExpression getTernaryExpression() {
    return findChildByClass(PsiFirestoreRulesTernaryExpression.class);
  }

}
