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

public class PsiFirestoreRulesLogicalExpressionImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesLogicalExpression {

  public PsiFirestoreRulesLogicalExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitLogicalExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesLogicalOperand> getLogicalOperandList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesLogicalOperand.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesLogicalOperator> getLogicalOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesLogicalOperator.class);
  }

}
