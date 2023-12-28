// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesAllowBlock extends PsiElement {

  @Nullable
  PsiFirestoreRulesAllowIfStmt getAllowIfStmt();

  @Nullable
  PsiFirestoreRulesPermissions getPermissions();

  @NotNull
  PsiElement getAllow();

  @Nullable
  PsiElement getSemicolon();

}
