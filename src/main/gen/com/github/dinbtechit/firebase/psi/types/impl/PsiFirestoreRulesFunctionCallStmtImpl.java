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

public class PsiFirestoreRulesFunctionCallStmtImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesFunctionCallStmt {

  public PsiFirestoreRulesFunctionCallStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitFunctionCallStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiFirestoreRulesFunctionCall getFunctionCall() {
    return findNotNullChildByClass(PsiFirestoreRulesFunctionCall.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesReturnVariable getReturnVariable() {
    return findChildByClass(PsiFirestoreRulesReturnVariable.class);
  }

}
