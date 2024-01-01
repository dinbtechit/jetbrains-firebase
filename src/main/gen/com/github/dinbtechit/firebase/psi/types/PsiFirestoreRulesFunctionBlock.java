// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.dinbtechit.firebase.language.referenceContributor.function.FirestoreFunctionDeclarationNamedElement;

public interface PsiFirestoreRulesFunctionBlock extends FirestoreFunctionDeclarationNamedElement {

  @Nullable
  PsiFirestoreRulesFunctionBody getFunctionBody();

  @Nullable
  PsiFirestoreRulesFunctionName getFunctionName();

  @Nullable
  PsiFirestoreRulesFunctionParameterList getFunctionParameterList();

  @NotNull
  PsiElement getFunction();

  @Nullable
  PsiElement getLParen();

  @Nullable
  PsiElement getRParen();

}
