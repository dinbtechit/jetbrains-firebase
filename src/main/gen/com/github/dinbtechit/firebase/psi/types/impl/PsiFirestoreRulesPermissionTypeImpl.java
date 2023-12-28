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

public class PsiFirestoreRulesPermissionTypeImpl extends ASTWrapperPsiElement implements PsiFirestoreRulesPermissionType {

  public PsiFirestoreRulesPermissionTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiFirestoreRulesVisitor visitor) {
    visitor.visitPermissionType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiFirestoreRulesVisitor) accept((PsiFirestoreRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCreate() {
    return findChildByType(CREATE);
  }

  @Override
  @Nullable
  public PsiElement getDelete() {
    return findChildByType(DELETE);
  }

  @Override
  @Nullable
  public PsiElement getGet() {
    return findChildByType(GET);
  }

  @Override
  @Nullable
  public PsiElement getList() {
    return findChildByType(LIST);
  }

  @Override
  @Nullable
  public PsiElement getRead() {
    return findChildByType(READ);
  }

  @Override
  @Nullable
  public PsiElement getUpdate() {
    return findChildByType(UPDATE);
  }

  @Override
  @Nullable
  public PsiElement getWrite() {
    return findChildByType(WRITE);
  }

}
