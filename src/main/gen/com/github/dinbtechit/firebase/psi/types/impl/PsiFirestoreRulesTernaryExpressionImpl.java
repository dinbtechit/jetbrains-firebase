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

public class PsiFirestoreRulesTernaryExpressionImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesTernaryExpression {

  public PsiFirestoreRulesTernaryExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitTernaryExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiFirestoreRulesTernaryCondition getTernaryCondition() {
    return findNotNullChildByClass(PsiFirestoreRulesTernaryCondition.class);
  }

  @Override
  @NotNull
  public PsiFirestoreRulesTernaryFalsePart getTernaryFalsePart() {
    return findNotNullChildByClass(PsiFirestoreRulesTernaryFalsePart.class);
  }

  @Override
  @NotNull
  public PsiFirestoreRulesTernaryTruePart getTernaryTruePart() {
    return findNotNullChildByClass(PsiFirestoreRulesTernaryTruePart.class);
  }

  @Override
  @NotNull
  public PsiElement getColon() {
    return findNotNullChildByType(COLON);
  }

  @Override
  @NotNull
  public PsiElement getQMark() {
    return findNotNullChildByType(Q_MARK);
  }

}
