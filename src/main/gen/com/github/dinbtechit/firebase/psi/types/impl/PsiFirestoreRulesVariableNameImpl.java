// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;
import com.github.dinbtechit.firebase.language.referenceContributor.variable.FirestoreVariableNamedElementImpl;
import com.github.dinbtechit.firebase.psi.types.*;
import com.github.dinbtechit.firebase.psi.RulesPsiImplUtil;

public class PsiFirestoreRulesVariableNameImpl extends FirestoreVariableNamedElementImpl implements PsiFirestoreRulesVariableName {

  public PsiFirestoreRulesVariableNameImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitVariableName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
