// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi.types;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PsiFirestoreRulesMatchBody extends PsiElement {

  @NotNull
  List<PsiFirestoreRulesAllowBlock> getAllowBlockList();

  @NotNull
  List<PsiFirestoreRulesFunctionBlock> getFunctionBlockList();

  @NotNull
  List<PsiFirestoreRulesMatchBlock> getMatchBlockList();

  @NotNull
  PsiElement getLBrace();

  @Nullable
  PsiElement getRBrace();

}
