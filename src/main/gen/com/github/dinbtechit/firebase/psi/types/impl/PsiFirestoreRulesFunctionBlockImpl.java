// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;
import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionDeclarationNamedElementImpl;
import com.github.dinbtechit.firebase.psi.types.*;

public class PsiFirestoreRulesFunctionBlockImpl extends FirestoreFunctionDeclarationNamedElementImpl implements PsiFirestoreRulesFunctionBlock {

  public PsiFirestoreRulesFunctionBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitFunctionBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesFunctionBody getFunctionBody() {
    return findChildByClass(PsiFirestoreRulesFunctionBody.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesFunctionName getFunctionName() {
    return findChildByClass(PsiFirestoreRulesFunctionName.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesFunctionParameterList getFunctionParameterList() {
    return findChildByClass(PsiFirestoreRulesFunctionParameterList.class);
  }

  @Override
  @NotNull
  public PsiElement getFunction() {
    return findNotNullChildByType(FUNCTION);
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
