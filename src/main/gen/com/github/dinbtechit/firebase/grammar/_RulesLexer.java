/* The following code was generated by JFlex 1.7.0-1 tweaked for IntelliJ platform */

package com.github.dinbtechit.firebase.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.dinbtechit.firebase.psi.FirestoreRulesTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-1
 * from the specification file <tt>/Users/srinivad/code/personal/jetbrains-plugins/jetbrains-firebase/src/main/kotlin/com/github/dinbtechit/firebase/grammar/_RulesLexer.flex</tt>
 */
public class _RulesLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [7, 7, 7]
   * Total runtime size is 1928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>14]|((ch>>7)&0x7f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 68 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\103\200");

  /* The ZZ_CMAP_Y table has 256 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\53\2\1\3\22\2\1\4\37\2\1\3\237\2");

  /* The ZZ_CMAP_A table has 640 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\4\1\22\0\1\2\1\50\1\17\1\55\1\25\1\53\1\46\1\15\1\26\1\27\1\23\1"+
    "\51\1\43\1\31\1\14\1\30\12\13\1\41\1\42\1\44\1\22\1\45\1\56\1\54\1\70\31\21"+
    "\1\37\1\16\1\40\1\52\1\32\1\0\1\10\1\71\1\60\1\65\1\6\1\7\1\64\1\63\1\34\2"+
    "\21\1\11\1\62\1\36\1\35\1\66\1\57\1\4\1\12\1\3\1\5\1\33\1\61\1\67\2\21\1\20"+
    "\1\47\1\24\7\0\1\1\32\0\1\2\337\0\1\2\177\0\13\2\35\0\2\1\5\0\1\2\57\0\1\2"+
    "\40\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\10\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\3\1\11\1\12\1\13\1\1\1\14\1\15"+
    "\1\16\1\17\2\3\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\26\3\1\4\1\0\1\40\4\0"+
    "\1\41\1\0\1\42\1\43\1\44\1\45\1\3\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\26\3"+
    "\1\56\4\3\1\0\1\57\1\60\1\0\1\61\5\3"+
    "\1\62\1\63\5\3\1\64\3\3\1\65\10\3\1\66"+
    "\2\3\1\0\1\42\1\67\7\3\1\70\1\71\1\72"+
    "\10\3\1\73\1\74\3\3\1\0\2\3\1\75\1\76"+
    "\5\3\1\77\2\3\1\100\1\101\1\3\1\102\1\103"+
    "\1\3\1\104\1\105\2\3\1\106\3\3\1\107\2\3"+
    "\1\110\4\3\1\111\1\3\1\112\1\113\1\114\1\115"+
    "\5\3\1\116\1\3\1\117";

  private static int [] zzUnpackAction() {
    int [] result = new int[222];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\72\0\164\0\256\0\350\0\u0122\0\u015c\0\u0196"+
    "\0\u01d0\0\u020a\0\u0244\0\u027e\0\72\0\u02b8\0\u02f2\0\u032c"+
    "\0\u0366\0\u03a0\0\72\0\72\0\u03da\0\72\0\72\0\u0414"+
    "\0\u0366\0\u044e\0\u0488\0\72\0\72\0\u04c2\0\72\0\72"+
    "\0\u04fc\0\u0536\0\u0570\0\u05aa\0\u05e4\0\72\0\72\0\72"+
    "\0\72\0\72\0\72\0\u061e\0\u0658\0\u0692\0\u06cc\0\u0706"+
    "\0\u0740\0\u077a\0\u07b4\0\u07ee\0\u0828\0\u0862\0\u089c\0\u08d6"+
    "\0\u0910\0\u094a\0\u0984\0\u09be\0\u09f8\0\u0a32\0\u0a6c\0\u0aa6"+
    "\0\u0ae0\0\u0b1a\0\u02b8\0\72\0\u0b54\0\u02f2\0\u0b8e\0\u0bc8"+
    "\0\72\0\u0c02\0\u0c3c\0\u0c76\0\u0366\0\u0cb0\0\u0cea\0\72"+
    "\0\72\0\72\0\72\0\72\0\72\0\72\0\72\0\u0d24"+
    "\0\u0d5e\0\u0d98\0\u0dd2\0\u0e0c\0\u0e46\0\u0e80\0\u0eba\0\u0ef4"+
    "\0\u0f2e\0\u0f68\0\u0fa2\0\u0fdc\0\u1016\0\u1050\0\u108a\0\u10c4"+
    "\0\u10fe\0\u1138\0\u1172\0\u11ac\0\u11e6\0\u0366\0\u1220\0\u125a"+
    "\0\u1294\0\u12ce\0\u1308\0\72\0\72\0\u1342\0\u0366\0\u137c"+
    "\0\u13b6\0\u13f0\0\u142a\0\u1464\0\u0366\0\u149e\0\u14d8\0\u1512"+
    "\0\u154c\0\u1586\0\u15c0\0\u0366\0\u15fa\0\u1634\0\u166e\0\u0366"+
    "\0\u16a8\0\u16e2\0\u171c\0\u1756\0\u1790\0\u17ca\0\u1804\0\u183e"+
    "\0\u0366\0\u1878\0\u18b2\0\u18ec\0\72\0\u0366\0\u1926\0\u1960"+
    "\0\u199a\0\u19d4\0\u1a0e\0\u1a48\0\u1a82\0\u0366\0\u0366\0\u0366"+
    "\0\u1abc\0\u1af6\0\u1b30\0\u1b6a\0\u1ba4\0\u1bde\0\u1c18\0\u1c52"+
    "\0\u0366\0\u0366\0\u1c8c\0\u1cc6\0\u1d00\0\u1d3a\0\u1d74\0\u1dae"+
    "\0\u0366\0\u0366\0\u1de8\0\u1e22\0\u1e5c\0\u1e96\0\u1ed0\0\u0366"+
    "\0\u1f0a\0\u1f44\0\u0366\0\u1f7e\0\u1fb8\0\u0366\0\u0366\0\u1ff2"+
    "\0\u0366\0\u0366\0\u202c\0\u2066\0\u0366\0\u20a0\0\u20da\0\u2114"+
    "\0\u0366\0\u214e\0\u2188\0\u0366\0\u21c2\0\u21fc\0\u2236\0\u2270"+
    "\0\u0366\0\u22aa\0\u0366\0\u0366\0\u0366\0\u0366\0\u22e4\0\u231e"+
    "\0\u2358\0\u2392\0\u23cc\0\u0366\0\u2406\0\u0366";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[222];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\2\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\2\21\1\32\1\21\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\21\1\54\1\55"+
    "\1\56\1\21\1\57\1\60\1\61\2\21\1\62\73\0"+
    "\2\3\72\0\1\21\1\63\7\21\5\0\1\21\7\0"+
    "\3\21\1\64\2\21\20\0\13\21\3\0\2\21\1\65"+
    "\1\66\5\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\11\21\5\0\1\21\7\0\6\21\20\0\7\21"+
    "\1\67\3\21\3\0\11\21\5\0\1\21\7\0\6\21"+
    "\20\0\10\21\1\70\2\21\3\0\2\21\1\71\2\21"+
    "\1\72\1\73\2\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\6\21\1\74\2\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\3\21\1\75\1\21\1\76"+
    "\3\21\5\0\1\21\7\0\3\21\1\77\2\21\20\0"+
    "\13\21\3\0\1\100\2\21\1\101\5\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\10\21\1\14\1\102"+
    "\4\0\1\21\7\0\6\21\20\0\13\21\15\103\1\104"+
    "\1\105\53\103\16\106\1\107\1\104\52\106\3\0\11\110"+
    "\5\0\1\110\10\0\5\110\20\0\13\110\3\0\11\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\22\0\1\111"+
    "\75\0\1\112\66\0\1\113\4\0\1\114\44\0\4\21"+
    "\1\115\4\21\5\0\1\21\7\0\5\21\1\116\20\0"+
    "\13\21\3\0\2\21\1\117\6\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\41\0\1\120\52\0\1\121\21\0"+
    "\1\122\47\0\1\123\22\0\1\124\72\0\1\125\72\0"+
    "\1\126\44\0\1\127\52\0\1\21\1\130\7\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\1\21\1\131"+
    "\7\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\5\21\1\132\3\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\3\21\1\133\5\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\2\21\1\134\1\135\5\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\5\21"+
    "\1\136\3\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\11\21\5\0\1\21\7\0\3\21\1\137\1\140"+
    "\1\21\20\0\13\21\3\0\2\21\1\141\6\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\11\21\5\0"+
    "\1\21\7\0\6\21\20\0\3\21\1\142\7\21\3\0"+
    "\6\21\1\143\2\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\1\144\4\21\1\145\1\21\1\146\1\21"+
    "\5\0\1\21\7\0\6\21\20\0\1\147\12\21\3\0"+
    "\11\21\5\0\1\21\7\0\6\21\20\0\6\21\1\150"+
    "\4\21\3\0\11\21\5\0\1\21\7\0\3\21\1\151"+
    "\2\21\20\0\13\21\3\0\11\21\5\0\1\21\7\0"+
    "\5\21\1\152\20\0\13\21\3\0\6\21\1\153\2\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\11\21"+
    "\5\0\1\21\7\0\4\21\1\154\1\21\20\0\13\21"+
    "\3\0\6\21\1\155\2\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\1\156\10\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\1\157\10\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\7\21\1\160\1\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\1\21"+
    "\1\161\7\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\1\21\1\162\7\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\13\0\1\102\56\0\1\103\1\0\70\103"+
    "\1\106\1\0\70\106\3\0\11\110\5\0\1\110\1\163"+
    "\1\0\1\164\5\0\5\110\20\0\13\110\3\0\12\112"+
    "\4\0\1\112\5\0\1\165\2\0\5\112\20\0\13\112"+
    "\23\113\1\166\46\113\1\114\1\0\70\114\3\0\1\167"+
    "\10\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\6\21\1\170\2\21\5\0\1\21\7\0\6\21\20\0"+
    "\3\21\1\171\7\21\3\0\3\21\1\172\5\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\11\21\5\0"+
    "\1\21\7\0\3\21\1\173\2\21\20\0\13\21\3\0"+
    "\1\174\10\21\5\0\1\21\7\0\6\21\20\0\7\21"+
    "\1\175\3\21\3\0\1\176\10\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\1\21\1\177\7\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\6\21\1\200"+
    "\2\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\1\201\10\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\11\21\5\0\1\21\7\0\5\21\1\202\20\0"+
    "\13\21\3\0\11\21\5\0\1\21\7\0\4\21\1\203"+
    "\1\21\20\0\13\21\3\0\3\21\1\204\5\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\3\21\1\205"+
    "\5\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\3\21\1\206\5\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\2\21\1\207\6\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\11\21\5\0\1\21\7\0"+
    "\6\21\20\0\6\21\1\210\4\21\3\0\11\21\5\0"+
    "\1\21\7\0\4\21\1\211\1\21\20\0\13\21\3\0"+
    "\2\21\1\212\6\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\5\21\1\213\3\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\7\21\1\214\1\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\11\21\5\0"+
    "\1\21\7\0\6\21\20\0\1\21\1\215\11\21\3\0"+
    "\7\21\1\141\1\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\5\21\1\216\3\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\11\21\5\0\1\21\7\0"+
    "\4\21\1\217\1\21\20\0\13\21\3\0\6\21\1\220"+
    "\2\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\1\221\10\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\11\21\5\0\1\21\7\0\3\21\1\222\2\21"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\2\21"+
    "\1\223\3\21\20\0\13\21\23\0\1\224\46\0\23\113"+
    "\1\166\4\113\1\225\41\113\3\0\6\21\1\226\2\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\11\21"+
    "\5\0\1\21\7\0\6\21\20\0\12\21\1\227\3\0"+
    "\5\21\1\230\3\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\1\231\10\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\6\21"+
    "\20\0\1\21\1\232\11\21\3\0\11\21\5\0\1\21"+
    "\7\0\6\21\20\0\11\21\1\233\1\21\3\0\5\21"+
    "\1\234\3\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\3\21\1\235\5\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\6\21"+
    "\20\0\4\21\1\236\6\21\3\0\11\21\5\0\1\21"+
    "\7\0\6\21\20\0\6\21\1\237\4\21\3\0\6\21"+
    "\1\240\2\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\7\21\1\241\1\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\7\21\1\242\1\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\1\21\1\243\7\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\2\21"+
    "\1\244\6\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\3\21\1\245\5\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\1\246\10\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\1\247\10\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\1\250\10\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\1\251\10\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\11\21"+
    "\5\0\1\21\7\0\6\21\20\0\2\21\1\252\10\21"+
    "\3\0\11\21\5\0\1\21\7\0\5\21\1\253\20\0"+
    "\13\21\3\0\11\21\5\0\1\21\7\0\5\21\1\254"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\3\21"+
    "\1\255\2\21\20\0\13\21\23\0\1\256\51\0\3\21"+
    "\1\257\5\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\1\260\10\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\3\21\1\261\5\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\11\21\5\0\1\21\7\0"+
    "\6\21\20\0\4\21\1\262\6\21\3\0\4\21\1\263"+
    "\4\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\1\264\10\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\1\265\10\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\1\266\10\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\1\21"+
    "\1\267\4\21\20\0\13\21\3\0\11\21\5\0\1\21"+
    "\7\0\5\21\1\270\20\0\13\21\3\0\1\21\1\271"+
    "\7\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\7\21\1\272\1\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\3\21\1\273\5\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\7\21\1\274\1\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\11\21\5\0"+
    "\1\21\7\0\3\21\1\275\2\21\20\0\13\21\3\0"+
    "\11\21\5\0\1\21\7\0\6\21\20\0\5\21\1\276"+
    "\5\21\3\0\11\21\5\0\1\21\7\0\6\21\20\0"+
    "\5\21\1\277\5\21\3\0\11\21\5\0\1\21\7\0"+
    "\6\21\20\0\1\21\1\300\11\21\24\0\1\164\50\0"+
    "\1\21\1\301\7\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\3\21\1\302\5\21\5\0\1\21\7\0"+
    "\6\21\20\0\13\21\3\0\1\303\10\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\11\21\5\0\1\21"+
    "\7\0\3\21\1\304\2\21\20\0\13\21\3\0\3\21"+
    "\1\305\5\21\5\0\1\21\7\0\6\21\20\0\13\21"+
    "\3\0\5\21\1\306\3\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\2\21"+
    "\1\307\3\21\20\0\13\21\3\0\11\21\5\0\1\21"+
    "\7\0\6\21\20\0\1\21\1\310\11\21\3\0\1\311"+
    "\10\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\11\21\5\0\1\21\7\0\6\21\20\0\11\21\1\312"+
    "\1\21\3\0\11\21\5\0\1\21\7\0\4\21\1\313"+
    "\1\21\20\0\13\21\3\0\3\21\1\314\5\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\3\21\1\315"+
    "\5\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\11\21\5\0\1\21\7\0\4\21\1\316\1\21\20\0"+
    "\13\21\3\0\11\21\5\0\1\21\7\0\6\21\20\0"+
    "\3\21\1\317\7\21\3\0\3\21\1\320\5\21\5\0"+
    "\1\21\7\0\6\21\20\0\13\21\3\0\3\21\1\321"+
    "\5\21\5\0\1\21\7\0\6\21\20\0\13\21\3\0"+
    "\4\21\1\322\4\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\11\21\5\0\1\21\7\0\5\21\1\323"+
    "\20\0\13\21\3\0\1\21\1\324\7\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\11\21\5\0\1\21"+
    "\7\0\5\21\1\325\20\0\13\21\3\0\11\21\5\0"+
    "\1\21\7\0\6\21\20\0\7\21\1\326\3\21\3\0"+
    "\1\21\1\327\7\21\5\0\1\21\7\0\6\21\20\0"+
    "\13\21\3\0\1\330\10\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\7\21\1\331\1\21\5\0\1\21"+
    "\7\0\6\21\20\0\13\21\3\0\3\21\1\332\5\21"+
    "\5\0\1\21\7\0\6\21\20\0\13\21\3\0\11\21"+
    "\5\0\1\21\7\0\3\21\1\333\2\21\20\0\13\21"+
    "\3\0\1\21\1\334\7\21\5\0\1\21\7\0\6\21"+
    "\20\0\13\21\3\0\11\21\5\0\1\21\7\0\4\21"+
    "\1\335\1\21\20\0\13\21\3\0\11\21\5\0\1\21"+
    "\7\0\5\21\1\336\20\0\13\21";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9280];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\12\1\1\11\5\1\2\11\1\1\2\11"+
    "\4\1\2\11\1\1\2\11\5\1\6\11\27\1\1\0"+
    "\1\11\4\0\1\11\1\0\5\1\10\11\33\1\1\0"+
    "\2\11\1\0\35\1\1\0\1\11\30\1\1\0\60\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[222];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _RulesLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _RulesLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 80: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 81: break;
          case 3: 
            { return IDENTIFIER;
            } 
            // fall through
          case 82: break;
          case 4: 
            { return NUMBER_LITERAL;
            } 
            // fall through
          case 83: break;
          case 5: 
            { return DOT;
            } 
            // fall through
          case 84: break;
          case 6: 
            { return QUOTE;
            } 
            // fall through
          case 85: break;
          case 7: 
            { return DOUBLE_QUOTE;
            } 
            // fall through
          case 86: break;
          case 8: 
            { return L_BRACE;
            } 
            // fall through
          case 87: break;
          case 9: 
            { return EQ;
            } 
            // fall through
          case 88: break;
          case 10: 
            { return MUL;
            } 
            // fall through
          case 89: break;
          case 11: 
            { return R_BRACE;
            } 
            // fall through
          case 90: break;
          case 12: 
            { return L_PAREN;
            } 
            // fall through
          case 91: break;
          case 13: 
            { return R_PAREN;
            } 
            // fall through
          case 92: break;
          case 14: 
            { return DIV;
            } 
            // fall through
          case 93: break;
          case 15: 
            { return MINUS;
            } 
            // fall through
          case 94: break;
          case 16: 
            { return L_BRACK;
            } 
            // fall through
          case 95: break;
          case 17: 
            { return R_BRACK;
            } 
            // fall through
          case 96: break;
          case 18: 
            { return COLON;
            } 
            // fall through
          case 97: break;
          case 19: 
            { return SEMICOLON;
            } 
            // fall through
          case 98: break;
          case 20: 
            { return COMMA;
            } 
            // fall through
          case 99: break;
          case 21: 
            { return LT;
            } 
            // fall through
          case 100: break;
          case 22: 
            { return GT;
            } 
            // fall through
          case 101: break;
          case 23: 
            { return AND;
            } 
            // fall through
          case 102: break;
          case 24: 
            { return OR;
            } 
            // fall through
          case 103: break;
          case 25: 
            { return EXCL;
            } 
            // fall through
          case 104: break;
          case 26: 
            { return PLUS;
            } 
            // fall through
          case 105: break;
          case 27: 
            { return XOR;
            } 
            // fall through
          case 106: break;
          case 28: 
            { return MODULO;
            } 
            // fall through
          case 107: break;
          case 29: 
            { return AT;
            } 
            // fall through
          case 108: break;
          case 30: 
            { return HASH;
            } 
            // fall through
          case 109: break;
          case 31: 
            { return Q_MARK;
            } 
            // fall through
          case 110: break;
          case 32: 
            { return STRING_LITERAL;
            } 
            // fall through
          case 111: break;
          case 33: 
            { return EQ_EQ;
            } 
            // fall through
          case 112: break;
          case 34: 
            { return BLOCK_COMMENT;
            } 
            // fall through
          case 113: break;
          case 35: 
            { return LINE_COMMENT;
            } 
            // fall through
          case 114: break;
          case 36: 
            { return IF;
            } 
            // fall through
          case 115: break;
          case 37: 
            { return IN;
            } 
            // fall through
          case 116: break;
          case 38: 
            { return COLON_COLON;
            } 
            // fall through
          case 117: break;
          case 39: 
            { return LT_EQ;
            } 
            // fall through
          case 118: break;
          case 40: 
            { return LT_LT;
            } 
            // fall through
          case 119: break;
          case 41: 
            { return GT_EQ;
            } 
            // fall through
          case 120: break;
          case 42: 
            { return GT_GT;
            } 
            // fall through
          case 121: break;
          case 43: 
            { return AND_AND;
            } 
            // fall through
          case 122: break;
          case 44: 
            { return OR_OR;
            } 
            // fall through
          case 123: break;
          case 45: 
            { return NOT_EQ;
            } 
            // fall through
          case 124: break;
          case 46: 
            { return LET;
            } 
            // fall through
          case 125: break;
          case 47: 
            { return PATH_VARIABLE_LITERAL;
            } 
            // fall through
          case 126: break;
          case 48: 
            { return PATH_BUILT_IN_LITERAL;
            } 
            // fall through
          case 127: break;
          case 49: 
            { return INT;
            } 
            // fall through
          case 128: break;
          case 50: 
            { return MAP;
            } 
            // fall through
          case 129: break;
          case 51: 
            { return GET;
            } 
            // fall through
          case 130: break;
          case 52: 
            { return BOOL_LITERAL;
            } 
            // fall through
          case 131: break;
          case 53: 
            { return READ;
            } 
            // fall through
          case 132: break;
          case 54: 
            { return LIST;
            } 
            // fall through
          case 133: break;
          case 55: 
            { return NULL_LITERAL;
            } 
            // fall through
          case 134: break;
          case 56: 
            { return PATH;
            } 
            // fall through
          case 135: break;
          case 57: 
            { return BIND;
            } 
            // fall through
          case 136: break;
          case 58: 
            { return BOOL;
            } 
            // fall through
          case 137: break;
          case 59: 
            { return FLOAT;
            } 
            // fall through
          case 138: break;
          case 60: 
            { return ALLOW;
            } 
            // fall through
          case 139: break;
          case 61: 
            { return WRITE;
            } 
            // fall through
          case 140: break;
          case 62: 
            { return MATCH;
            } 
            // fall through
          case 141: break;
          case 63: 
            { return RETURN;
            } 
            // fall through
          case 142: break;
          case 64: 
            { return UPDATE;
            } 
            // fall through
          case 143: break;
          case 65: 
            { return EXISTS;
            } 
            // fall through
          case 144: break;
          case 66: 
            { return LATLNG;
            } 
            // fall through
          case 145: break;
          case 67: 
            { return STRING;
            } 
            // fall through
          case 146: break;
          case 68: 
            { return NUMBER;
            } 
            // fall through
          case 147: break;
          case 69: 
            { return CREATE;
            } 
            // fall through
          case 148: break;
          case 70: 
            { return DELETE;
            } 
            // fall through
          case 149: break;
          case 71: 
            { return REQUEST;
            } 
            // fall through
          case 150: break;
          case 72: 
            { return SERVICE;
            } 
            // fall through
          case 151: break;
          case 73: 
            { return RESOURCE;
            } 
            // fall through
          case 152: break;
          case 74: 
            { return FUNCTION;
            } 
            // fall through
          case 153: break;
          case 75: 
            { return GET_AFTER;
            } 
            // fall through
          case 154: break;
          case 76: 
            { return DURATION;
            } 
            // fall through
          case 155: break;
          case 77: 
            { return TIMESTAMP;
            } 
            // fall through
          case 156: break;
          case 78: 
            { return EXISTS_AFTER;
            } 
            // fall through
          case 157: break;
          case 79: 
            { return RULES_VERSION;
            } 
            // fall through
          case 158: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
