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

public class PsiFirestoreRulesFunctionBodyImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesFunctionBody {

  public PsiFirestoreRulesFunctionBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitFunctionBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesCommentRule> getCommentRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesCommentRule.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesExpressionWrapperWithSemi> getExpressionWrapperWithSemiList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesExpressionWrapperWithSemi.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesFunctionCallStmtWithSemi> getFunctionCallStmtWithSemiList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesFunctionCallStmtWithSemi.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesReturnStmt> getReturnStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesReturnStmt.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesVariableAssignment> getVariableAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesVariableAssignment.class);
  }

  @Override
  @NotNull
  public List<PsiFirestoreRulesVariableDeclaration> getVariableDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PsiFirestoreRulesVariableDeclaration.class);
  }

  @Override
  @NotNull
  public PsiElement getLBrace() {
    return findNotNullChildByType(L_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getRBrace() {
    return findChildByType(R_BRACE);
  }

}
