// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;
import static com.github.dinbtechit.firebase.language.parser.RulesParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RulesParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return ruleFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // "+" | "-"
  public static boolean add_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "add_op")) return false;
    if (!nextTokenIs(builder_, "<add op>", MINUS, PLUS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ADD_OP, "<add op>");
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ALLOW permissions allowConditionOrSemi
  public static boolean allowBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "allowBlock")) return false;
    if (!nextTokenIs(builder_, ALLOW)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ALLOW_BLOCK, null);
    result_ = consumeToken(builder_, ALLOW);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, permissions(builder_, level_ + 1));
    result_ = pinned_ && allowConditionOrSemi(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // allowIfStmt | SEMICOLON
  static boolean allowConditionOrSemi(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "allowConditionOrSemi")) return false;
    if (!nextTokenIs(builder_, "", COLON, SEMICOLON)) return false;
    boolean result_;
    result_ = allowIfStmt(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, SEMICOLON);
    return result_;
  }

  /* ********************************************************** */
  // ifLogic | ifLogicWithBrackets
  public static boolean allowIfCondition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "allowIfCondition")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ALLOW_IF_CONDITION, "<allow if condition>");
    result_ = ifLogic(builder_, level_ + 1);
    if (!result_) result_ = ifLogicWithBrackets(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // COLON IF allowIfCondition SEMICOLON
  public static boolean allowIfStmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "allowIfStmt")) return false;
    if (!nextTokenIs(builder_, COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ALLOW_IF_STMT, null);
    result_ = consumeTokens(builder_, 1, COLON, IF);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, allowIfCondition(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // term (add_op term)*
  public static boolean arithmeticExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmeticExpression")) return false;
    if (!nextTokenIs(builder_, "<arithmetic expression>", L_PAREN, NUMBER_LITERAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARITHMETIC_EXPRESSION, "<arithmetic expression>");
    result_ = term(builder_, level_ + 1);
    result_ = result_ && arithmeticExpression_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (add_op term)*
  private static boolean arithmeticExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmeticExpression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!arithmeticExpression_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arithmeticExpression_1", pos_)) break;
    }
    return true;
  }

  // add_op term
  private static boolean arithmeticExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmeticExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = add_op(builder_, level_ + 1);
    result_ = result_ && term(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT
  public static boolean blockCommentRule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "blockCommentRule")) return false;
    if (!nextTokenIs(builder_, BLOCK_COMMENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BLOCK_COMMENT);
    exit_section_(builder_, marker_, BLOCK_COMMENT_RULE, result_);
    return result_;
  }

  /* ********************************************************** */
  // BOOL_LITERAL
  public static boolean booleanExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "booleanExpression")) return false;
    if (!nextTokenIs(builder_, BOOL_LITERAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BOOL_LITERAL);
    exit_section_(builder_, marker_, BOOLEAN_EXPRESSION, result_);
    return result_;
  }

  /* ********************************************************** */
  // LINE_COMMENT|blockCommentRule
  public static boolean commentRule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "commentRule")) return false;
    if (!nextTokenIs(builder_, "<comment rule>", BLOCK_COMMENT, LINE_COMMENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, COMMENT_RULE, "<comment rule>");
    result_ = consumeToken(builder_, LINE_COMMENT);
    if (!result_) result_ = blockCommentRule(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ternaryExpression
  //                         | logicalExpression
  //                         | arithmeticExpression
  //                         | booleanExpression
  public static boolean expressionWrapper(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionWrapper")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPRESSION_WRAPPER, "<expression wrapper>");
    result_ = ternaryExpression(builder_, level_ + 1);
    if (!result_) result_ = logicalExpression(builder_, level_ + 1);
    if (!result_) result_ = arithmeticExpression(builder_, level_ + 1);
    if (!result_) result_ = booleanExpression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // expressionWrapper SEMICOLON
  public static boolean expressionWrapperWithSemi(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionWrapperWithSemi")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPRESSION_WRAPPER_WITH_SEMI, "<expression wrapper with semi>");
    result_ = expressionWrapper(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // NUMBER_LITERAL | "(" arithmeticExpression ")"
  public static boolean factor(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "factor")) return false;
    if (!nextTokenIs(builder_, "<factor>", L_PAREN, NUMBER_LITERAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FACTOR, "<factor>");
    result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = factor_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // "(" arithmeticExpression ")"
  private static boolean factor_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "factor_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_PAREN);
    result_ = result_ && arithmeticExpression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // BOOL_LITERAL | STRING_LITERAL | NULL_LITERAL | NUMBER_LITERAL | expressionWrapper | jsonObject | jsonArray | functionCallStmt | object | variableName
  public static boolean functionArgument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionArgument")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_ARGUMENT, "<function argument>");
    result_ = consumeToken(builder_, BOOL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NULL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = expressionWrapper(builder_, level_ + 1);
    if (!result_) result_ = jsonObject(builder_, level_ + 1);
    if (!result_) result_ = jsonArray(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = object(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // functionArgument (',' functionArgument)*
  public static boolean functionArgumentList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionArgumentList")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_ARGUMENT_LIST, "<function argument list>");
    result_ = functionArgument(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && functionArgumentList_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (',' functionArgument)*
  private static boolean functionArgumentList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionArgumentList_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!functionArgumentList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "functionArgumentList_1", pos_)) break;
    }
    return true;
  }

  // ',' functionArgument
  private static boolean functionArgumentList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionArgumentList_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && functionArgument(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // FUNCTION functionName '(' functionParameterList? ')' functionBody
  public static boolean functionBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBlock")) return false;
    if (!nextTokenIs(builder_, FUNCTION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_BLOCK, null);
    result_ = consumeToken(builder_, FUNCTION);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, functionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, L_PAREN)) && result_;
    result_ = pinned_ && report_error_(builder_, functionBlock_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, R_PAREN)) && result_;
    result_ = pinned_ && functionBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // functionParameterList?
  private static boolean functionBlock_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBlock_3")) return false;
    functionParameterList(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' functionBodyElements* '}'
  public static boolean functionBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBody")) return false;
    if (!nextTokenIs(builder_, L_BRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_BODY, null);
    result_ = consumeToken(builder_, L_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, functionBody_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, R_BRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // functionBodyElements*
  private static boolean functionBody_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBody_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!functionBodyElements(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "functionBody_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // commentRule | variableDeclaration
  //                                  | variableAssignment | expressionWrapperWithSemi
  //                                  | functionCallStmtWithSemi | returnStmt
  static boolean functionBodyElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBodyElements")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = commentRule(builder_, level_ + 1);
    if (!result_) result_ = variableDeclaration(builder_, level_ + 1);
    if (!result_) result_ = variableAssignment(builder_, level_ + 1);
    if (!result_) result_ = expressionWrapperWithSemi(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmtWithSemi(builder_, level_ + 1);
    if (!result_) result_ = returnStmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, RulesParser::functionBodyRecover);
    return result_;
  }

  /* ********************************************************** */
  // !('}'|variableDeclaration | variableAssignment
  //                                      | expressionWrapperWithSemi
  //                                      | functionCallStmtWithSemi | returnStmt)
  static boolean functionBodyRecover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBodyRecover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !functionBodyRecover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // '}'|variableDeclaration | variableAssignment
  //                                      | expressionWrapperWithSemi
  //                                      | functionCallStmtWithSemi | returnStmt
  private static boolean functionBodyRecover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionBodyRecover_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, R_BRACE);
    if (!result_) result_ = variableDeclaration(builder_, level_ + 1);
    if (!result_) result_ = variableAssignment(builder_, level_ + 1);
    if (!result_) result_ = expressionWrapperWithSemi(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmtWithSemi(builder_, level_ + 1);
    if (!result_) result_ = returnStmt(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // functionName '(' functionArgumentList? ')' returnVariable?
  public static boolean functionCallStmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionCallStmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_CALL_STMT, "<function call stmt>");
    result_ = functionName(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, L_PAREN);
    result_ = result_ && functionCallStmt_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    result_ = result_ && functionCallStmt_4(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // functionArgumentList?
  private static boolean functionCallStmt_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionCallStmt_2")) return false;
    functionArgumentList(builder_, level_ + 1);
    return true;
  }

  // returnVariable?
  private static boolean functionCallStmt_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionCallStmt_4")) return false;
    returnVariable(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // functionCallStmt SEMICOLON
  public static boolean functionCallStmtWithSemi(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionCallStmtWithSemi")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_CALL_STMT_WITH_SEMI, "<function call stmt with semi>");
    result_ = functionCallStmt(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'get' | BIND | IDENTIFIER
  public static boolean functionName(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionName")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_NAME, "<function name>");
    result_ = consumeToken(builder_, GET);
    if (!result_) result_ = consumeToken(builder_, BIND);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // variableName
  public static boolean functionParameter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionParameter")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = variableName(builder_, level_ + 1);
    exit_section_(builder_, marker_, FUNCTION_PARAMETER, result_);
    return result_;
  }

  /* ********************************************************** */
  // functionParameter (',' functionParameter )*
  public static boolean functionParameterList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionParameterList")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_PARAMETER_LIST, null);
    result_ = functionParameter(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && functionParameterList_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (',' functionParameter )*
  private static boolean functionParameterList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionParameterList_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!functionParameterList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "functionParameterList_1", pos_)) break;
    }
    return true;
  }

  // ',' functionParameter
  private static boolean functionParameterList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionParameterList_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && functionParameter(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '/' getSubPath ('/' getSubPath)*
  public static boolean getPath(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "getPath")) return false;
    if (!nextTokenIs(builder_, DIV)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GET_PATH, null);
    result_ = consumeToken(builder_, DIV);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, getSubPath(builder_, level_ + 1));
    result_ = pinned_ && getPath_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ('/' getSubPath)*
  private static boolean getPath_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "getPath_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!getPath_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "getPath_2", pos_)) break;
    }
    return true;
  }

  // '/' getSubPath
  private static boolean getPath_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "getPath_2_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, DIV);
    pinned_ = result_; // pin = 1
    result_ = result_ && getSubPath(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // IDENTIFIER | NUMBER_LITERAL | PATH_BUILT_IN_LITERAL
  static boolean getSubPath(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "getSubPath")) return false;
    boolean result_;
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, PATH_BUILT_IN_LITERAL);
    return result_;
  }

  /* ********************************************************** */
  // expressionWrapper | rulesMethod | functionCallStmt | object | variableName
  static boolean ifConditionExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifConditionExpression")) return false;
    boolean result_;
    result_ = expressionWrapper(builder_, level_ + 1);
    if (!result_) result_ = rulesMethod(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = object(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // ifConditionExpression
  public static boolean ifLogic(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifLogic")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IF_LOGIC, "<if logic>");
    result_ = ifConditionExpression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // L_PAREN ifConditionExpression R_PAREN
  public static boolean ifLogicWithBrackets(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifLogicWithBrackets")) return false;
    if (!nextTokenIs(builder_, L_PAREN)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IF_LOGIC_WITH_BRACKETS, null);
    result_ = consumeToken(builder_, L_PAREN);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, ifConditionExpression(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, R_PAREN) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // REQUEST | RESOURCE | variableName
  static boolean interfaceType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "interfaceType")) return false;
    boolean result_;
    result_ = consumeToken(builder_, REQUEST);
    if (!result_) result_ = consumeToken(builder_, RESOURCE);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '[' jsonValue (',' jsonValue)* ']'
  public static boolean jsonArray(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonArray")) return false;
    if (!nextTokenIs(builder_, L_BRACK)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_BRACK);
    result_ = result_ && jsonValue(builder_, level_ + 1);
    result_ = result_ && jsonArray_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACK);
    exit_section_(builder_, marker_, JSON_ARRAY, result_);
    return result_;
  }

  // (',' jsonValue)*
  private static boolean jsonArray_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonArray_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!jsonArray_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "jsonArray_2", pos_)) break;
    }
    return true;
  }

  // ',' jsonValue
  private static boolean jsonArray_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonArray_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && jsonValue(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '{' pair (',' pair)* '}'
  public static boolean jsonObject(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonObject")) return false;
    if (!nextTokenIs(builder_, L_BRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_BRACE);
    result_ = result_ && pair(builder_, level_ + 1);
    result_ = result_ && jsonObject_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACE);
    exit_section_(builder_, marker_, JSON_OBJECT, result_);
    return result_;
  }

  // (',' pair)*
  private static boolean jsonObject_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonObject_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!jsonObject_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "jsonObject_2", pos_)) break;
    }
    return true;
  }

  // ',' pair
  private static boolean jsonObject_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonObject_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && pair(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // STRING_LITERAL | NUMBER_LITERAL | jsonObject | jsonArray | BOOL_LITERAL | 'null'
  public static boolean jsonValue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonValue")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, JSON_VALUE, "<json value>");
    result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = jsonObject(builder_, level_ + 1);
    if (!result_) result_ = jsonArray(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, BOOL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NULL_LITERAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean keyValue(PsiBuilder builder_, int level_) {
    return consumeToken(builder_, STRING_LITERAL);
  }

  /* ********************************************************** */
  // logicalOperand logicalOperator logicalOperand [(logicalOperator logicalOperand)*]
  public static boolean logicalExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logicalExpression")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOGICAL_EXPRESSION, "<logical expression>");
    result_ = logicalOperand(builder_, level_ + 1);
    result_ = result_ && logicalOperator(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, logicalOperand(builder_, level_ + 1));
    result_ = pinned_ && logicalExpression_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [(logicalOperator logicalOperand)*]
  private static boolean logicalExpression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logicalExpression_3")) return false;
    logicalExpression_3_0(builder_, level_ + 1);
    return true;
  }

  // (logicalOperator logicalOperand)*
  private static boolean logicalExpression_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logicalExpression_3_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!logicalExpression_3_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "logicalExpression_3_0", pos_)) break;
    }
    return true;
  }

  // logicalOperator logicalOperand
  private static boolean logicalExpression_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logicalExpression_3_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = logicalOperator(builder_, level_ + 1);
    result_ = result_ && logicalOperand(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // NULL_LITERAL | NUMBER_LITERAL | STRING_LITERAL | BOOL_LITERAL | rulesMethod | functionCallStmt | object | variableName
  public static boolean logicalOperand(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logicalOperand")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOGICAL_OPERAND, "<logical operand>");
    result_ = consumeToken(builder_, NULL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = consumeToken(builder_, BOOL_LITERAL);
    if (!result_) result_ = rulesMethod(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = object(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '&&' | '||' | '&' | '|' | '!=' | '==' | '>=' | '<=' | '<' | '>'
  public static boolean logicalOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logicalOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOGICAL_OPERATOR, "<logical operator>");
    result_ = consumeToken(builder_, AND_AND);
    if (!result_) result_ = consumeToken(builder_, OR_OR);
    if (!result_) result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, OR);
    if (!result_) result_ = consumeToken(builder_, NOT_EQ);
    if (!result_) result_ = consumeToken(builder_, EQ_EQ);
    if (!result_) result_ = consumeToken(builder_, GT_EQ);
    if (!result_) result_ = consumeToken(builder_, LT_EQ);
    if (!result_) result_ = consumeToken(builder_, LT);
    if (!result_) result_ = consumeToken(builder_, GT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // variableName '[' (variableName | STRING_LITERAL | NUMBER_LITERAL | NULL_LITERAL) ']'
  public static boolean mapVariable(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mapVariable")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = variableName(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, L_BRACK);
    result_ = result_ && mapVariable_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACK);
    exit_section_(builder_, marker_, MAP_VARIABLE, result_);
    return result_;
  }

  // variableName | STRING_LITERAL | NUMBER_LITERAL | NULL_LITERAL
  private static boolean mapVariable_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mapVariable_2")) return false;
    boolean result_;
    result_ = variableName(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, NULL_LITERAL);
    return result_;
  }

  /* ********************************************************** */
  // MATCH matchPath matchBody
  public static boolean matchBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchBlock")) return false;
    if (!nextTokenIs(builder_, MATCH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MATCH_BLOCK, null);
    result_ = consumeToken(builder_, MATCH);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, matchPath(builder_, level_ + 1));
    result_ = pinned_ && matchBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '{' matchBodyElements* '}'
  public static boolean matchBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchBody")) return false;
    if (!nextTokenIs(builder_, L_BRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MATCH_BODY, null);
    result_ = consumeToken(builder_, L_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, matchBody_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, R_BRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // matchBodyElements*
  private static boolean matchBody_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchBody_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!matchBodyElements(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "matchBody_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // allowBlock | functionBlock | matchBlock
  static boolean matchBodyElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchBodyElements")) return false;
    boolean result_;
    result_ = allowBlock(builder_, level_ + 1);
    if (!result_) result_ = functionBlock(builder_, level_ + 1);
    if (!result_) result_ = matchBlock(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '/' path ('/' path)*
  public static boolean matchPath(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchPath")) return false;
    if (!nextTokenIs(builder_, DIV)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MATCH_PATH, null);
    result_ = consumeToken(builder_, DIV);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, path(builder_, level_ + 1));
    result_ = pinned_ && matchPath_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ('/' path)*
  private static boolean matchPath_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchPath_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!matchPath_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "matchPath_2", pos_)) break;
    }
    return true;
  }

  // '/' path
  private static boolean matchPath_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matchPath_2_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, DIV);
    pinned_ = result_; // pin = 1
    result_ = result_ && path(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // GET | GET_AFTER | EXISTS | EXISTS_AFTER
  static boolean methods(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methods")) return false;
    boolean result_;
    result_ = consumeToken(builder_, GET);
    if (!result_) result_ = consumeToken(builder_, GET_AFTER);
    if (!result_) result_ = consumeToken(builder_, EXISTS);
    if (!result_) result_ = consumeToken(builder_, EXISTS_AFTER);
    return result_;
  }

  /* ********************************************************** */
  // "*" | "/" | '%'
  public static boolean mult_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mult_op")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MULT_OP, "<mult op>");
    result_ = consumeToken(builder_, MUL);
    if (!result_) result_ = consumeToken(builder_, DIV);
    if (!result_) result_ = consumeToken(builder_, MODULO);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // interfaceType  ('.'  objectProperty)*
  public static boolean object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "object")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OBJECT, "<object>");
    result_ = interfaceType(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && object_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ('.'  objectProperty)*
  private static boolean object_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "object_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!object_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "object_1", pos_)) break;
    }
    return true;
  }

  // '.'  objectProperty
  private static boolean object_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "object_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, DOT);
    pinned_ = result_; // pin = 1
    result_ = result_ && objectProperty(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // functionCallStmt | mapVariable | interfaceType | variableName
  public static boolean objectProperty(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "objectProperty")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OBJECT_PROPERTY, "<object property>");
    result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = mapVariable(builder_, level_ + 1);
    if (!result_) result_ = interfaceType(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // keyValue ':' jsonValue
  static boolean pair(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pair")) return false;
    if (!nextTokenIs(builder_, STRING_LITERAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = keyValue(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && jsonValue(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER | NUMBER_LITERAL | PATH_VARIABLE_LITERAL
  static boolean path(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "path")) return false;
    boolean result_;
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, PATH_VARIABLE_LITERAL);
    return result_;
  }

  /* ********************************************************** */
  // GET|CREATE|LIST|READ|WRITE|DELETE|UPDATE {
  // }
  public static boolean permissionType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissionType")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PERMISSION_TYPE, "<permission type>");
    result_ = consumeToken(builder_, GET);
    if (!result_) result_ = consumeToken(builder_, CREATE);
    if (!result_) result_ = consumeToken(builder_, LIST);
    if (!result_) result_ = consumeToken(builder_, READ);
    if (!result_) result_ = consumeToken(builder_, WRITE);
    if (!result_) result_ = consumeToken(builder_, DELETE);
    if (!result_) result_ = permissionType_6(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // UPDATE {
  // }
  private static boolean permissionType_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissionType_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, UPDATE);
    result_ = result_ && permissionType_6_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // {
  // }
  private static boolean permissionType_6_1(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // !(';'|':'|allowBlock|matchBlock|functionBlock|' '|'}')
  static boolean permissionTypeRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissionTypeRecovery")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !permissionTypeRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ';'|':'|allowBlock|matchBlock|functionBlock|' '|'}'
  private static boolean permissionTypeRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissionTypeRecovery_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMICOLON);
    if (!result_) result_ = consumeToken(builder_, COLON);
    if (!result_) result_ = allowBlock(builder_, level_ + 1);
    if (!result_) result_ = matchBlock(builder_, level_ + 1);
    if (!result_) result_ = functionBlock(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, " ");
    if (!result_) result_ = consumeToken(builder_, R_BRACE);
    return result_;
  }

  /* ********************************************************** */
  // permissionType (',' permissionType)*
  public static boolean permissions(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissions")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PERMISSIONS, "<permissions>");
    result_ = permissionType(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && permissions_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, RulesParser::permissionTypeRecovery);
    return result_ || pinned_;
  }

  // (',' permissionType)*
  private static boolean permissions_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissions_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!permissions_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "permissions_1", pos_)) break;
    }
    return true;
  }

  // ',' permissionType
  private static boolean permissions_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "permissions_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && permissionType(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // !(<<eof>>|serviceBlock)
  static boolean recovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recovery")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !recovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // <<eof>>|serviceBlock
  private static boolean recovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recovery_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = eof(builder_, level_ + 1);
    if (!result_) result_ = serviceBlock(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // RETURN (returnStmtElements*) SEMICOLON
  public static boolean returnStmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnStmt")) return false;
    if (!nextTokenIs(builder_, RETURN)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RETURN_STMT, null);
    result_ = consumeToken(builder_, RETURN);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, returnStmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // returnStmtElements*
  private static boolean returnStmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnStmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!returnStmtElements(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "returnStmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expressionWrapper | functionCallStmt | rulesMethod | variableName
  public static boolean returnStmtElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnStmtElements")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RETURN_STMT_ELEMENTS, "<return stmt elements>");
    result_ = expressionWrapper(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = rulesMethod(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // functionCallStmt | mapVariable | variableName
  public static boolean returnVariable(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnVariable")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RETURN_VARIABLE, "<return variable>");
    result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = mapVariable(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '.' returnVariable ( '.' returnVariable)*
  public static boolean returnVariableBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnVariableBlock")) return false;
    if (!nextTokenIs(builder_, DOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && returnVariable(builder_, level_ + 1);
    result_ = result_ && returnVariableBlock_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, RETURN_VARIABLE_BLOCK, result_);
    return result_;
  }

  // ( '.' returnVariable)*
  private static boolean returnVariableBlock_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnVariableBlock_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!returnVariableBlock_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "returnVariableBlock_2", pos_)) break;
    }
    return true;
  }

  // '.' returnVariable
  private static boolean returnVariableBlock_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnVariableBlock_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && returnVariable(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // versionDef? (serviceBlock*)?
  static boolean ruleFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ruleFile")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = ruleFile_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && ruleFile_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // versionDef?
  private static boolean ruleFile_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ruleFile_0")) return false;
    versionDef(builder_, level_ + 1);
    return true;
  }

  // (serviceBlock*)?
  private static boolean ruleFile_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ruleFile_1")) return false;
    ruleFile_1_0(builder_, level_ + 1);
    return true;
  }

  // serviceBlock*
  private static boolean ruleFile_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ruleFile_1_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!serviceBlock(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ruleFile_1_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // returnVariableBlock
  public static boolean ruleMethodReturnVariable(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ruleMethodReturnVariable")) return false;
    if (!nextTokenIs(builder_, DOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = returnVariableBlock(builder_, level_ + 1);
    exit_section_(builder_, marker_, RULE_METHOD_RETURN_VARIABLE, result_);
    return result_;
  }

  /* ********************************************************** */
  // methods "(" getPath ")" ruleMethodReturnVariable?
  public static boolean rulesMethod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rulesMethod")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RULES_METHOD, "<rules method>");
    result_ = methods(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, L_PAREN));
    result_ = pinned_ && report_error_(builder_, getPath(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, R_PAREN)) && result_;
    result_ = pinned_ && rulesMethod_4(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ruleMethodReturnVariable?
  private static boolean rulesMethod_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rulesMethod_4")) return false;
    ruleMethodReturnVariable(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // SERVICE serviceName serviceBody
  public static boolean serviceBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBlock")) return false;
    if (!nextTokenIs(builder_, SERVICE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SERVICE_BLOCK, null);
    result_ = consumeToken(builder_, SERVICE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, serviceName(builder_, level_ + 1));
    result_ = pinned_ && serviceBody(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '{'  serviceElements*  '}'
  public static boolean serviceBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBody")) return false;
    if (!nextTokenIs(builder_, L_BRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SERVICE_BODY, null);
    result_ = consumeToken(builder_, L_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, serviceBody_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, R_BRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // serviceElements*
  private static boolean serviceBody_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBody_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!serviceElements(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "serviceBody_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !('}'| functionBlock | matchBlock )
  static boolean serviceBodyRecover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBodyRecover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !serviceBodyRecover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // '}'| functionBlock | matchBlock
  private static boolean serviceBodyRecover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBodyRecover_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, R_BRACE);
    if (!result_) result_ = functionBlock(builder_, level_ + 1);
    if (!result_) result_ = matchBlock(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // !('{')
  static boolean serviceElementRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceElementRecovery")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, L_BRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // functionBlock | matchBlock
  static boolean serviceElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceElements")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = functionBlock(builder_, level_ + 1);
    if (!result_) result_ = matchBlock(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, RulesParser::serviceBodyRecover);
    return result_;
  }

  /* ********************************************************** */
  // "cloud.firestore"| "firebase.storage"
  public static boolean serviceName(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceName")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SERVICE_NAME, "<service name>");
    result_ = consumeToken(builder_, "cloud.firestore");
    if (!result_) result_ = consumeToken(builder_, "firebase.storage");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // factor (mult_op factor)*
  public static boolean term(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "term")) return false;
    if (!nextTokenIs(builder_, "<term>", L_PAREN, NUMBER_LITERAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TERM, "<term>");
    result_ = factor(builder_, level_ + 1);
    result_ = result_ && term_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (mult_op factor)*
  private static boolean term_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "term_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!term_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "term_1", pos_)) break;
    }
    return true;
  }

  // mult_op factor
  private static boolean term_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "term_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = mult_op(builder_, level_ + 1);
    result_ = result_ && factor(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // logicalExpression | BOOL_LITERAL | functionCallStmt | variableName |
  public static boolean ternaryCondition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ternaryCondition")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TERNARY_CONDITION, "<ternary condition>");
    result_ = logicalExpression(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, BOOL_LITERAL);
    if (!result_) result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TERNARYCONDITION_4_0);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ternaryCondition '?' ternaryTruePart ':' ternaryFalsePart
  public static boolean ternaryExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ternaryExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TERNARY_EXPRESSION, "<ternary expression>");
    result_ = ternaryCondition(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, Q_MARK);
    result_ = result_ && ternaryTruePart(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && ternaryFalsePart(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // functionCallStmt | variableName | NUMBER_LITERAL | BOOL_LITERAL | STRING_LITERAL
  public static boolean ternaryFalsePart(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ternaryFalsePart")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TERNARY_FALSE_PART, "<ternary false part>");
    result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, BOOL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // functionCallStmt | variableName | NUMBER_LITERAL | BOOL_LITERAL | STRING_LITERAL
  public static boolean ternaryTruePart(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ternaryTruePart")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TERNARY_TRUE_PART, "<ternary true part>");
    result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, BOOL_LITERAL);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // variableName "=" variableAssignmentElements SEMICOLON
  public static boolean variableAssignment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableAssignment")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VARIABLE_ASSIGNMENT, null);
    result_ = variableName(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQ);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, variableAssignmentElements(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // expressionWrapper | functionCallStmt | variableName | NUMBER_LITERAL | STRING_LITERAL
  static boolean variableAssignmentElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableAssignmentElements")) return false;
    boolean result_;
    result_ = expressionWrapper(builder_, level_ + 1);
    if (!result_) result_ = functionCallStmt(builder_, level_ + 1);
    if (!result_) result_ = variableName(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    return result_;
  }

  /* ********************************************************** */
  // LET variableName variableDeclarationElements
  public static boolean variableDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclaration")) return false;
    if (!nextTokenIs(builder_, LET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VARIABLE_DECLARATION, null);
    result_ = consumeToken(builder_, LET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, variableName(builder_, level_ + 1));
    result_ = pinned_ && variableDeclarationElements(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // variableInitialization | SEMICOLON
  static boolean variableDeclarationElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarationElements")) return false;
    if (!nextTokenIs(builder_, "", EQ, SEMICOLON)) return false;
    boolean result_;
    result_ = variableInitialization(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, SEMICOLON);
    return result_;
  }

  /* ********************************************************** */
  // "=" variableAssignmentElements SEMICOLON
  public static boolean variableInitialization(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableInitialization")) return false;
    if (!nextTokenIs(builder_, EQ)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VARIABLE_INITIALIZATION, null);
    result_ = consumeToken(builder_, EQ);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, variableAssignmentElements(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean variableName(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableName")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, VARIABLE_NAME, result_);
    return result_;
  }

  /* ********************************************************** */
  // RULES_VERSION '=' STRING_LITERAL SEMICOLON
  public static boolean versionDef(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "versionDef")) return false;
    if (!nextTokenIs(builder_, RULES_VERSION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VERSION_DEF, null);
    result_ = consumeTokens(builder_, 1, RULES_VERSION, EQ, STRING_LITERAL, SEMICOLON);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

}
