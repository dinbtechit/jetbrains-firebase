// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesTernaryExpression extends PsiElement {

  @NotNull
  PsiFirestoreRulesTernaryCondition getTernaryCondition();

  @NotNull
  PsiFirestoreRulesTernaryFalsePart getTernaryFalsePart();

  @NotNull
  PsiFirestoreRulesTernaryTruePart getTernaryTruePart();

  @NotNull
  PsiElement getColon();

  @NotNull
  PsiElement getQMark();

}
