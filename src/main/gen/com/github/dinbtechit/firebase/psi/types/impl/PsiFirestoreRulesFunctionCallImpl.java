// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;
import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionCallNamedElementImpl;
import com.github.dinbtechit.firebase.psi.types.*;

public class PsiFirestoreRulesFunctionCallImpl extends FirestoreFunctionCallNamedElementImpl implements PsiFirestoreRulesFunctionCall {

  public PsiFirestoreRulesFunctionCallImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesFunctionArgumentList getFunctionArgumentList() {
    return findChildByClass(PsiFirestoreRulesFunctionArgumentList.class);
  }

  @Override
  @NotNull
  public PsiFirestoreRulesFunctionName getFunctionName() {
    return findNotNullChildByClass(PsiFirestoreRulesFunctionName.class);
  }

  @Override
  @NotNull
  public PsiElement getLParen() {
    return findNotNullChildByType(L_PAREN);
  }

  @Override
  @NotNull
  public PsiElement getRParen() {
    return findNotNullChildByType(R_PAREN);
  }

}
