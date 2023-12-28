// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesObject extends PsiElement {

  @NotNull
  List<PsiFirestoreRulesObjectProperty> getObjectPropertyList();

  @Nullable
  PsiFirestoreRulesVariableName getVariableName();

  @Nullable
  PsiElement getRequest();

  @Nullable
  PsiElement getResource();

}
