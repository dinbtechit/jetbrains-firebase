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

public class PsiFirestoreRulesRulesMethodImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesRulesMethod {

  public PsiFirestoreRulesRulesMethodImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitRulesMethod(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesGetPath getGetPath() {
    return findChildByClass(PsiFirestoreRulesGetPath.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesRuleMethodReturnVariable getRuleMethodReturnVariable() {
    return findChildByClass(PsiFirestoreRulesRuleMethodReturnVariable.class);
  }

  @Override
  @Nullable
  public PsiElement getExists() {
    return findChildByType(EXISTS);
  }

  @Override
  @Nullable
  public PsiElement getExistsAfter() {
    return findChildByType(EXISTS_AFTER);
  }

  @Override
  @Nullable
  public PsiElement getGet() {
    return findChildByType(GET);
  }

  @Override
  @Nullable
  public PsiElement getGetAfter() {
    return findChildByType(GET_AFTER);
  }

  @Override
  @Nullable
  public PsiElement getLParen() {
    return findChildByType(L_PAREN);
  }

  @Override
  @Nullable
  public PsiElement getRParen() {
    return findChildByType(R_PAREN);
  }

}
