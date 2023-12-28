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

public class PsiFirestoreRulesMapVariableImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesMapVariable {

  public PsiFirestoreRulesMapVariableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitMapVariable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesVariableName> getVariableNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesVariableName.class);
  }

  @Override
  @NotNull
  public PsiElement getLBrack() {
    return findNotNullChildByType(L_BRACK);
  }

  @Override
  @Nullable
  public PsiElement getNullLiteral() {
    return findChildByType(NULL_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getNumberLiteral() {
    return findChildByType(NUMBER_LITERAL);
  }

  @Override
  @NotNull
  public PsiElement getRBrack() {
    return findNotNullChildByType(R_BRACK);
  }

  @Override
  @Nullable
  public PsiElement getStringLiteral() {
    return findChildByType(STRING_LITERAL);
  }

}
