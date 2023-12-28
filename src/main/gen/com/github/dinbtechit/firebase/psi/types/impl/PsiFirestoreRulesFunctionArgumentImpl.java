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

public class PsiFirestoreRulesFunctionArgumentImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesFunctionArgument {

  public PsiFirestoreRulesFunctionArgumentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitFunctionArgument(this);
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
  public PsiFirestoreRulesJsonArray getJsonArray() {
    return findChildByClass(PsiFirestoreRulesJsonArray.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesJsonObject getJsonObject() {
    return findChildByClass(PsiFirestoreRulesJsonObject.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesObject getObject() {
    return findChildByClass(PsiFirestoreRulesObject.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesVariableName getVariableName() {
    return findChildByClass(PsiFirestoreRulesVariableName.class);
  }

  @Override
  @Nullable
  public PsiElement getBoolLiteral() {
    return findChildByType(BOOL_LITERAL);
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
  @Nullable
  public PsiElement getStringLiteral() {
    return findChildByType(STRING_LITERAL);
  }

}
