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

public class PsiFirestoreRulesTermImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesTerm {

  public PsiFirestoreRulesTermImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitTerm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesFactor> getFactorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesFactor.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesMultOp> getMultOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesMultOp.class);
  }

}
