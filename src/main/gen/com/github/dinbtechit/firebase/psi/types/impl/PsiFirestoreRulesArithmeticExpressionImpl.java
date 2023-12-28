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

public class PsiFirestoreRulesArithmeticExpressionImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesArithmeticExpression {

  public PsiFirestoreRulesArithmeticExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitArithmeticExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesAddOp> getAddOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesAddOp.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesTerm> getTermList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesTerm.class);
  }

}
