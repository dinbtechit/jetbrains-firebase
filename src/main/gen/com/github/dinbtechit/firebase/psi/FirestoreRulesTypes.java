// This is a generated file. Not intended for manual editing.
package com.github.dinbtechit.firebase.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.dinbtechit.firebase.psi.types.RuleBlockCommentElement;
import com.github.dinbtechit.firebase.psi.types.RuleCommentElement;
import com.github.dinbtechit.firebase.psi.types.impl.*;

public interface FirestoreRulesTypes {

  IElementType ADD_OP = new RulesElementTypes("ADD_OP");
  IElementType ALLOW_BLOCK = new RulesElementTypes("ALLOW_BLOCK");
  IElementType ALLOW_IF_CONDITION = new RulesElementTypes("ALLOW_IF_CONDITION");
  IElementType ALLOW_IF_STMT = new RulesElementTypes("ALLOW_IF_STMT");
  IElementType ARITHMETIC_EXPRESSION = new RulesElementTypes("ARITHMETIC_EXPRESSION");
  IElementType BLOCK_COMMENT_RULE = new RuleBlockCommentElement("BLOCK_COMMENT_RULE");
  IElementType BOOLEAN_EXPRESSION = new RulesElementTypes("BOOLEAN_EXPRESSION");
  IElementType COMMENT_RULE = new RuleCommentElement("COMMENT_RULE");
  IElementType EXPRESSION_WRAPPER = new RulesElementTypes("EXPRESSION_WRAPPER");
  IElementType EXPRESSION_WRAPPER_WITH_SEMI = new RulesElementTypes("EXPRESSION_WRAPPER_WITH_SEMI");
  IElementType FACTOR = new RulesElementTypes("FACTOR");
  IElementType FUNCTION_ARGUMENT = new RulesElementTypes("FUNCTION_ARGUMENT");
  IElementType FUNCTION_ARGUMENT_LIST = new RulesElementTypes("FUNCTION_ARGUMENT_LIST");
  IElementType FUNCTION_BLOCK = new RulesElementTypes("FUNCTION_BLOCK");
  IElementType FUNCTION_BODY = new RulesElementTypes("FUNCTION_BODY");
  IElementType FUNCTION_CALL = new RulesElementTypes("FUNCTION_CALL");
  IElementType FUNCTION_CALL_STMT = new RulesElementTypes("FUNCTION_CALL_STMT");
  IElementType FUNCTION_CALL_STMT_WITH_SEMI = new RulesElementTypes("FUNCTION_CALL_STMT_WITH_SEMI");
  IElementType FUNCTION_NAME = new RulesElementTypes("FUNCTION_NAME");
  IElementType FUNCTION_PARAMETER = new RulesElementTypes("FUNCTION_PARAMETER");
  IElementType FUNCTION_PARAMETER_LIST = new RulesElementTypes("FUNCTION_PARAMETER_LIST");
  IElementType GET_PATH = new RulesElementTypes("GET_PATH");
  IElementType IF_LOGIC = new RulesElementTypes("IF_LOGIC");
  IElementType IF_LOGIC_WITH_BRACKETS = new RulesElementTypes("IF_LOGIC_WITH_BRACKETS");
  IElementType JSON_ARRAY = new RulesElementTypes("JSON_ARRAY");
  IElementType JSON_OBJECT = new RulesElementTypes("JSON_OBJECT");
  IElementType JSON_VALUE = new RulesElementTypes("JSON_VALUE");
  IElementType LOGICAL_EXPRESSION = new RulesElementTypes("LOGICAL_EXPRESSION");
  IElementType LOGICAL_OPERAND = new RulesElementTypes("LOGICAL_OPERAND");
  IElementType LOGICAL_OPERATOR = new RulesElementTypes("LOGICAL_OPERATOR");
  IElementType MAP_VARIABLE = new RulesElementTypes("MAP_VARIABLE");
  IElementType MATCH_BLOCK = new RulesElementTypes("MATCH_BLOCK");
  IElementType MATCH_BODY = new RulesElementTypes("MATCH_BODY");
  IElementType MATCH_PATH = new RulesElementTypes("MATCH_PATH");
  IElementType MULT_OP = new RulesElementTypes("MULT_OP");
  IElementType OBJECT = new RulesElementTypes("OBJECT");
  IElementType OBJECT_PROPERTY = new RulesElementTypes("OBJECT_PROPERTY");
  IElementType PERMISSIONS = new RulesElementTypes("PERMISSIONS");
  IElementType PERMISSION_TYPE = new RulesElementTypes("PERMISSION_TYPE");
  IElementType RETURN_STMT = new RulesElementTypes("RETURN_STMT");
  IElementType RETURN_STMT_ELEMENTS = new RulesElementTypes("RETURN_STMT_ELEMENTS");
  IElementType RETURN_VARIABLE = new RulesElementTypes("RETURN_VARIABLE");
  IElementType RETURN_VARIABLE_BLOCK = new RulesElementTypes("RETURN_VARIABLE_BLOCK");
  IElementType RULES_METHOD = new RulesElementTypes("RULES_METHOD");
  IElementType RULE_METHOD_RETURN_VARIABLE = new RulesElementTypes("RULE_METHOD_RETURN_VARIABLE");
  IElementType SERVICE_BLOCK = new RulesElementTypes("SERVICE_BLOCK");
  IElementType SERVICE_BODY = new RulesElementTypes("SERVICE_BODY");
  IElementType SERVICE_NAME = new RulesElementTypes("SERVICE_NAME");
  IElementType TERM = new RulesElementTypes("TERM");
  IElementType TERNARY_CONDITION = new RulesElementTypes("TERNARY_CONDITION");
  IElementType TERNARY_EXPRESSION = new RulesElementTypes("TERNARY_EXPRESSION");
  IElementType TERNARY_FALSE_PART = new RulesElementTypes("TERNARY_FALSE_PART");
  IElementType TERNARY_TRUE_PART = new RulesElementTypes("TERNARY_TRUE_PART");
  IElementType VARIABLE_ASSIGNMENT = new RulesElementTypes("VARIABLE_ASSIGNMENT");
  IElementType VARIABLE_DECLARATION = new RulesElementTypes("VARIABLE_DECLARATION");
  IElementType VARIABLE_INITIALIZATION = new RulesElementTypes("VARIABLE_INITIALIZATION");
  IElementType VARIABLE_NAME = new RulesElementTypes("VARIABLE_NAME");
  IElementType VERSION_DEF = new RulesElementTypes("VERSION_DEF");

  IElementType ALLOW = new RulesTokenType("allow");
  IElementType AND = new RulesTokenType("&");
  IElementType AND_AND = new RulesTokenType("&&");
  IElementType AT = new RulesTokenType("@");
  IElementType BIND = new RulesTokenType("bind");
  IElementType BLOCK_COMMENT = new RulesTokenType("BLOCK_COMMENT");
  IElementType BOOL = new RulesTokenType("bool");
  IElementType BOOL_LITERAL = new RulesTokenType("BOOL_LITERAL");
  IElementType COLON = new RulesTokenType(":");
  IElementType COLON_COLON = new RulesTokenType("::");
  IElementType COMMA = new RulesTokenType(",");
  IElementType CREATE = new RulesTokenType("create");
  IElementType DELETE = new RulesTokenType("delete");
  IElementType DIV = new RulesTokenType("/");
  IElementType DOT = new RulesTokenType(".");
  IElementType DOUBLE_QUOTE = new RulesTokenType("\"");
  IElementType DURATION = new RulesTokenType("duration");
  IElementType EQ = new RulesTokenType("=");
  IElementType EQ_EQ = new RulesTokenType("==");
  IElementType EXCL = new RulesTokenType("!");
  IElementType EXISTS = new RulesTokenType("exists");
  IElementType EXISTS_AFTER = new RulesTokenType("existsAfter");
  IElementType FLOAT = new RulesTokenType("float");
  IElementType FUNCTION = new RulesTokenType("function");
  IElementType GET = new RulesTokenType("get");
  IElementType GET_AFTER = new RulesTokenType("getAfter");
  IElementType GT = new RulesTokenType(">");
  IElementType GT_EQ = new RulesTokenType(">=");
  IElementType GT_GT = new RulesTokenType(">>");
  IElementType HASH = new RulesTokenType("#");
  IElementType IDENTIFIER = new RulesTokenType("IDENTIFIER");
  IElementType IF = new RulesTokenType("if");
  IElementType IN = new RulesTokenType("in");
  IElementType INT = new RulesTokenType("int");
  IElementType LATLNG = new RulesTokenType("latlng");
  IElementType LET = new RulesTokenType("let");
  IElementType LINE_COMMENT = new RulesTokenType("LINE_COMMENT");
  IElementType LIST = new RulesTokenType("list");
  IElementType LT = new RulesTokenType("<");
  IElementType LT_EQ = new RulesTokenType("<=");
  IElementType LT_LT = new RulesTokenType("<<");
  IElementType L_BRACE = new RulesTokenType("{");
  IElementType L_BRACK = new RulesTokenType("[");
  IElementType L_PAREN = new RulesTokenType("(");
  IElementType MAP = new RulesTokenType("map");
  IElementType MATCH = new RulesTokenType("match");
  IElementType MINUS = new RulesTokenType("-");
  IElementType MODULO = new RulesTokenType("%");
  IElementType MUL = new RulesTokenType("*");
  IElementType NOT_EQ = new RulesTokenType("!=");
  IElementType NULL_LITERAL = new RulesTokenType("null");
  IElementType NUMBER = new RulesTokenType("number");
  IElementType NUMBER_LITERAL = new RulesTokenType("NUMBER_LITERAL");
  IElementType OR = new RulesTokenType("|");
  IElementType OR_OR = new RulesTokenType("||");
  IElementType PATH = new RulesTokenType("path");
  IElementType PATH_BUILT_IN_LITERAL = new RulesTokenType("PATH_BUILT_IN_LITERAL");
  IElementType PATH_VARIABLE_LITERAL = new RulesTokenType("PATH_VARIABLE_LITERAL");
  IElementType PLUS = new RulesTokenType("+");
  IElementType QUOTE = new RulesTokenType("'");
  IElementType Q_MARK = new RulesTokenType("?");
  IElementType READ = new RulesTokenType("read");
  IElementType REQUEST = new RulesTokenType("request");
  IElementType RESOURCE = new RulesTokenType("resource");
  IElementType RETURN = new RulesTokenType("return");
  IElementType RULES_VERSION = new RulesTokenType("rules_version");
  IElementType R_BRACE = new RulesTokenType("}");
  IElementType R_BRACK = new RulesTokenType("]");
  IElementType R_PAREN = new RulesTokenType(")");
  IElementType SEMICOLON = new RulesTokenType(";");
  IElementType SERVICE = new RulesTokenType("service");
  IElementType STRING = new RulesTokenType("string");
  IElementType STRING_LITERAL = new RulesTokenType("STRING_LITERAL");
  IElementType TERNARYCONDITION_4_0 = new RulesTokenType("ternaryCondition_4_0");
  IElementType TIMESTAMP = new RulesTokenType("timestamp");
  IElementType UPDATE = new RulesTokenType("update");
  IElementType WRITE = new RulesTokenType("write");
  IElementType XOR = new RulesTokenType("^");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_OP) {
        return new PsiFirestoreRulesAddOpImpl(node);
      }
      else if (type == ALLOW_BLOCK) {
        return new PsiFirestoreRulesAllowBlockImpl(node);
      }
      else if (type == ALLOW_IF_CONDITION) {
        return new PsiFirestoreRulesAllowIfConditionImpl(node);
      }
      else if (type == ALLOW_IF_STMT) {
        return new PsiFirestoreRulesAllowIfStmtImpl(node);
      }
      else if (type == ARITHMETIC_EXPRESSION) {
        return new PsiFirestoreRulesArithmeticExpressionImpl(node);
      }
      else if (type == BLOCK_COMMENT_RULE) {
        return new PsiFirestoreRulesBlockCommentRuleImpl(node);
      }
      else if (type == BOOLEAN_EXPRESSION) {
        return new PsiFirestoreRulesBooleanExpressionImpl(node);
      }
      else if (type == COMMENT_RULE) {
        return new PsiFirestoreRulesCommentRuleImpl(node);
      }
      else if (type == EXPRESSION_WRAPPER) {
        return new PsiFirestoreRulesExpressionWrapperImpl(node);
      }
      else if (type == EXPRESSION_WRAPPER_WITH_SEMI) {
        return new PsiFirestoreRulesExpressionWrapperWithSemiImpl(node);
      }
      else if (type == FACTOR) {
        return new PsiFirestoreRulesFactorImpl(node);
      }
      else if (type == FUNCTION_ARGUMENT) {
        return new PsiFirestoreRulesFunctionArgumentImpl(node);
      }
      else if (type == FUNCTION_ARGUMENT_LIST) {
        return new PsiFirestoreRulesFunctionArgumentListImpl(node);
      }
      else if (type == FUNCTION_BLOCK) {
        return new PsiFirestoreRulesFunctionBlockImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new PsiFirestoreRulesFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new PsiFirestoreRulesFunctionCallImpl(node);
      }
      else if (type == FUNCTION_CALL_STMT) {
        return new PsiFirestoreRulesFunctionCallStmtImpl(node);
      }
      else if (type == FUNCTION_CALL_STMT_WITH_SEMI) {
        return new PsiFirestoreRulesFunctionCallStmtWithSemiImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new PsiFirestoreRulesFunctionNameImpl(node);
      }
      else if (type == FUNCTION_PARAMETER) {
        return new PsiFirestoreRulesFunctionParameterImpl(node);
      }
      else if (type == FUNCTION_PARAMETER_LIST) {
        return new PsiFirestoreRulesFunctionParameterListImpl(node);
      }
      else if (type == GET_PATH) {
        return new PsiFirestoreRulesGetPathImpl(node);
      }
      else if (type == IF_LOGIC) {
        return new PsiFirestoreRulesIfLogicImpl(node);
      }
      else if (type == IF_LOGIC_WITH_BRACKETS) {
        return new PsiFirestoreRulesIfLogicWithBracketsImpl(node);
      }
      else if (type == JSON_ARRAY) {
        return new PsiFirestoreRulesJsonArrayImpl(node);
      }
      else if (type == JSON_OBJECT) {
        return new PsiFirestoreRulesJsonObjectImpl(node);
      }
      else if (type == JSON_VALUE) {
        return new PsiFirestoreRulesJsonValueImpl(node);
      }
      else if (type == LOGICAL_EXPRESSION) {
        return new PsiFirestoreRulesLogicalExpressionImpl(node);
      }
      else if (type == LOGICAL_OPERAND) {
        return new PsiFirestoreRulesLogicalOperandImpl(node);
      }
      else if (type == LOGICAL_OPERATOR) {
        return new PsiFirestoreRulesLogicalOperatorImpl(node);
      }
      else if (type == MAP_VARIABLE) {
        return new PsiFirestoreRulesMapVariableImpl(node);
      }
      else if (type == MATCH_BLOCK) {
        return new PsiFirestoreRulesMatchBlockImpl(node);
      }
      else if (type == MATCH_BODY) {
        return new PsiFirestoreRulesMatchBodyImpl(node);
      }
      else if (type == MATCH_PATH) {
        return new PsiFirestoreRulesMatchPathImpl(node);
      }
      else if (type == MULT_OP) {
        return new PsiFirestoreRulesMultOpImpl(node);
      }
      else if (type == OBJECT) {
        return new PsiFirestoreRulesObjectImpl(node);
      }
      else if (type == OBJECT_PROPERTY) {
        return new PsiFirestoreRulesObjectPropertyImpl(node);
      }
      else if (type == PERMISSIONS) {
        return new PsiFirestoreRulesPermissionsImpl(node);
      }
      else if (type == PERMISSION_TYPE) {
        return new PsiFirestoreRulesPermissionTypeImpl(node);
      }
      else if (type == RETURN_STMT) {
        return new PsiFirestoreRulesReturnStmtImpl(node);
      }
      else if (type == RETURN_STMT_ELEMENTS) {
        return new PsiFirestoreRulesReturnStmtElementsImpl(node);
      }
      else if (type == RETURN_VARIABLE) {
        return new PsiFirestoreRulesReturnVariableImpl(node);
      }
      else if (type == RETURN_VARIABLE_BLOCK) {
        return new PsiFirestoreRulesReturnVariableBlockImpl(node);
      }
      else if (type == RULES_METHOD) {
        return new PsiFirestoreRulesRulesMethodImpl(node);
      }
      else if (type == RULE_METHOD_RETURN_VARIABLE) {
        return new PsiFirestoreRulesRuleMethodReturnVariableImpl(node);
      }
      else if (type == SERVICE_BLOCK) {
        return new PsiFirestoreRulesServiceBlockImpl(node);
      }
      else if (type == SERVICE_BODY) {
        return new PsiFirestoreRulesServiceBodyImpl(node);
      }
      else if (type == SERVICE_NAME) {
        return new PsiFirestoreRulesServiceNameImpl(node);
      }
      else if (type == TERM) {
        return new PsiFirestoreRulesTermImpl(node);
      }
      else if (type == TERNARY_CONDITION) {
        return new PsiFirestoreRulesTernaryConditionImpl(node);
      }
      else if (type == TERNARY_EXPRESSION) {
        return new PsiFirestoreRulesTernaryExpressionImpl(node);
      }
      else if (type == TERNARY_FALSE_PART) {
        return new PsiFirestoreRulesTernaryFalsePartImpl(node);
      }
      else if (type == TERNARY_TRUE_PART) {
        return new PsiFirestoreRulesTernaryTruePartImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT) {
        return new PsiFirestoreRulesVariableAssignmentImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new PsiFirestoreRulesVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_INITIALIZATION) {
        return new PsiFirestoreRulesVariableInitializationImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new PsiFirestoreRulesVariableNameImpl(node);
      }
      else if (type == VERSION_DEF) {
        return new PsiFirestoreRulesVersionDefImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
