package com.github.dinbtechit.firebase.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;

%%

%{
  public _RulesLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _RulesLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

WHITESPACE=[ \n\t\r\f]
BOOL_LITERAL=(true)|(false)
NUMBER_LITERAL=[0-9]+(\.[0-9]*)?
STRING_LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
PATH_VARIABLE_LITERAL=\{[_a-zA-Z0-9]+(=\*\*)?}
PATH_BUILT_IN_LITERAL=\$\([._a-zA-Z0-9]*\)
IDENTIFIER=[_a-zA-Z0-9\-]+
LINE_COMMENT="//"[^\n]*\n?
BLOCK_COMMENT=("/"\*([^*]|(\*+[^*/]))*(\*+"/"))

%%
<YYINITIAL> {
  {WHITE_SPACE}                 { return WHITE_SPACE; }

  "{"                           { return L_BRACE; }
  "}"                           { return R_BRACE; }
  "["                           { return L_BRACK; }
  "]"                           { return R_BRACK; }
  "("                           { return L_PAREN; }
  ")"                           { return R_PAREN; }
  "::"                          { return COLON_COLON; }
  ":"                           { return COLON; }
  ";"                           { return SEMICOLON; }
  ","                           { return COMMA; }
  "'"                           { return QUOTE; }
  "\""                          { return DOUBLE_QUOTE; }
  "<"                           { return LT; }
  ">"                           { return GT; }
  "&"                           { return AND; }
  "|"                           { return OR; }
  "=="                          { return EQ_EQ; }
  "!="                          { return NOT_EQ; }
  "="                           { return EQ; }
  "."                           { return DOT; }
  "!"                           { return EXCL; }
  "+"                           { return PLUS; }
  "-"                           { return MINUS; }
  "^"                           { return XOR; }
  "*"                           { return MUL; }
  "/"                           { return DIV; }
  "%"                           { return MODULO; }
  "@"                           { return AT; }
  "#"                           { return HASH; }
  "?"                           { return Q_MARK; }
  "<="                          { return LT_EQ; }
  "<<"                          { return LT_LT; }
  ">="                          { return GT_EQ; }
  ">>"                          { return GT_GT; }
  "||"                          { return OR_OR; }
  "&&"                          { return AND_AND; }
  "request"                     { return REQUEST; }
  "resource"                    { return RESOURCE; }
  "rules_version"               { return RULES_VERSION; }
  "service"                     { return SERVICE; }
  "allow"                       { return ALLOW; }
  "function"                    { return FUNCTION; }
  "match"                       { return MATCH; }
  "let"                         { return LET; }
  "if"                          { return IF; }
  "return"                      { return RETURN; }
  "exists"                      { return EXITS; }
  "get"                         { return GET; }
  "read"                        { return READ; }
  "write"                       { return WRITE; }
  "list"                        { return LIST; }
  "create"                      { return CREATE; }
  "update"                      { return UPDATE; }
  "delete"                      { return DELETE; }
  "bool_kw"                     { return BOOL; }
  "int_kw"                      { return INT; }
  "float_kw"                    { return FLOAT; }
  "number_kw"                   { return NUMBER; }
  "string_kw"                   { return STRING; }
  "map_kw"                      { return MAP; }
  "timestamp_kw"                { return TIMESTAMP; }
  "duration_kw"                 { return DURATION; }
  "latlng_kw"                   { return LATLNG; }

  {WHITESPACE}                  { return WHITESPACE; }
  {BOOL_LITERAL}                { return BOOL_LITERAL; }
  {NUMBER_LITERAL}              { return NUMBER_LITERAL; }
  {STRING_LITERAL}              { return STRING_LITERAL; }
  {PATH_VARIABLE_LITERAL}       { return PATH_VARIABLE_LITERAL; }
  {PATH_BUILT_IN_LITERAL}       { return PATH_BUILT_IN_LITERAL; }
  {IDENTIFIER}                  { return IDENTIFIER; }
  {LINE_COMMENT}                { return LINE_COMMENT; }
  {BLOCK_COMMENT}               { return BLOCK_COMMENT; }

}

[^] { return BAD_CHARACTER; }
