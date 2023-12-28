// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesVariableDeclaration extends PsiElement {

  @Nullable
  PsiFirestoreRulesVariableInitialization getVariableInitialization();

  @Nullable
  PsiFirestoreRulesVariableName getVariableName();

  @NotNull
  PsiElement getLet();

  @Nullable
  PsiElement getSemicolon();

}
