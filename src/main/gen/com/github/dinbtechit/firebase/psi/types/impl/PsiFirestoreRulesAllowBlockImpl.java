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

public class PsiFirestoreRulesAllowBlockImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesAllowBlock {

  public PsiFirestoreRulesAllowBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitAllowBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesAllowIfStmt getAllowIfStmt() {
    return findChildByClass(PsiFirestoreRulesAllowIfStmt.class);
  }

  @Override
  @Nullable
  public PsiFirestoreRulesPermissions getPermissions() {
    return findChildByClass(PsiFirestoreRulesPermissions.class);
  }

  @Override
  @NotNull
  public PsiElement getAllow() {
    return findNotNullChildByType(ALLOW);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

}
