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

public class PsiFirestoreRulesIfLogicWithBracketsImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesIfLogicWithBrackets {

  public PsiFirestoreRulesIfLogicWithBracketsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitIfLogicWithBrackets(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesExpressionWrapper getExpressionWrapper() {
    return findChildByClass(PsiFirestoreRulesExpressionWrapper.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesFunctionCallStmt getFunctionCallStmt() {
    return findChildByClass(PsiFirestoreRulesFunctionCallStmt.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesObject getObject() {
    return findChildByClass(PsiFirestoreRulesObject.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesRulesMethod getRulesMethod() {
    return findChildByClass(PsiFirestoreRulesRulesMethod.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesVariableName getVariableName() {
    return findChildByClass(PsiFirestoreRulesVariableName.class);
  }

  @Override
  @NotNull
  public PsiElement getLParen() {
    return findNotNullChildByType(L_PAREN);
  }

  @Override
  @Nullable
  public PsiElement getRParen() {
    return findChildByType(R_PAREN);
  }

}
