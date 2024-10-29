grammar Slang;

// PARSERSKA GRAMATIKA
start: statement* EOF;

statement
    : declaration ';'
    | printStatement ';'
    | expr ';'
    /*| for  // pocetak naseg dodavanja
    | while
    | scanf
    | funkcija
    | if i else*/
    ;

declaration
    : NUMBER_KEYWORD ID '=' expr ';'
    | BOOLEAN_KEYWORD ID '=' expr ';'
    | expr ';'
    ;

printStatement
    : PRINT_KEYWORD '(' expr (COMMA expr)* ')' // Print statement
    // proveriti na koji nacin bi ispisivali niz
    ;

expr: orExpr;

orExpr
    : andExpr (OR andExpr)* // Omogućava više `||` izraza
    ;

andExpr
    : equalityExpr (AND equalityExpr)* // Omogućava više `&&` izraza
    ;


equalityExpr
    : relationalExpr ((EQUAL | NOTEQUAL) relationalExpr)* // Omogućava poređenje jednakosti
    ;

relationalExpr
    : addSubExpr ((GT | LT | GE | LE) addSubExpr)* // Omogućava relacije
    ;

addSubExpr
    : mulDivExpr ( (ADD | SUB) mulDivExpr)* // Omogućava sabiranje i oduzimanje
    ;

mulDivExpr
    : exponentExpr ((MUL | DIV | MOD) exponentExpr)* // Omogućava množenje, deljenje, mod
    ;

exponentExpr
    : atom (CARET exponentExpr)? // Desno asocijativno eksponenciranje
    ;

atom
    : NUMBER_KEYWORD #NumberConstant
    | ID #VariableReference
    | '(' expr ')' #GroupingOperator
    | squad #ArrayConstructor
    ;

squad
    : '[' (expr (COMMA expr)*)? ']'
    ;







// LEKSICKA GRAMATIKA

fragment DIGIT: [0-9];
/*
** proveriti za grab i dropmsg
*/
IF_KEYWORD: 'check';
ELSE_KEYWORD: 'backup';
FOR_KEYWORD: 'spin';
WHILE_KEYWORD: 'replay';
NUMBER_KEYWORD: 'numero';
BOOLEAN_KEYWORD: 'yeahNah';
RETURN_KEYWORD: 'getback';
VOID_KEYWORD: 'empty';
PRINT_KEYWORD: 'dropmsg';
SCAN_KEYWORD: 'grabmsg';
// LITERALS
BOOL_LITERAL: 'true' | 'false';
NUMBER_LITERAL: ('-')? DIGIT+ ('.' DIGIT+)?;

// Separators
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI   : ';';
COMMA  : ',';
DOT    : '.';

// Operators

ASSIGN   : '=';
GT       : '>';
LT       : '<';
BANG     : '!';
COLON    : ':';
EQUAL    : '==';
LE       : '<=';
GE       : '>=';
NOTEQUAL : '!=';
AND      : '&&';
OR       : '||';
ADD      : '+';
SUB      : '-';
MUL      : '*';
DIV      : '/';
BITAND   : '&';
BITOR    : '|';
MOD      : '%';
CARET    : '^';
// IDENTIFIERS
ID : [a-zA-Z] [a-zA-Z0-9]* ; // match usual identifier spec
//DIGIT : [0-9]+ ; // match integers

// COMMENTS AND SPACES
SPACES: [ \u000B\t\r\n\p{White_Space}] -> skip;
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;