// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionCallNamedElement;

public interface PsiFirestoreRulesFunctionCall extends FirestoreFunctionCallNamedElement {

  @Nullable
  PsiFirestoreRulesFunctionArgumentList getFunctionArgumentList();

  @NotNull
  PsiFirestoreRulesFunctionName getFunctionName();

  @NotNull
  PsiElement getLParen();

  @NotNull
  PsiElement getRParen();

}
