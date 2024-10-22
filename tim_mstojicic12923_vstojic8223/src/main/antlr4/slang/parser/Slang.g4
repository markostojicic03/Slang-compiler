lexer grammar Slang;
/*
** proveriti za grab i dropmsg
*/
fragment DIGIT: [0-9];

IF_KEYWORD: 'check';
ELSE_KEYWORD: 'backup';
FOR_KEYWORD: 'spin';
WHILE_KEYWORD: 'replay';
NUMBER_KEYWORD: 'numero';
BOOLEAN_KEYWORD: 'yeahNah';
RETURN: 'getback';
VOID: 'empty';



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



// IDENTIFIERS
ID : [a-zA-Z] [a-zA-Z0-9]* ; // match usual identifier spec
//INT : [0-9]+ ; // match integers


// COMMENTS AND SPACES
SPACES: [ \u000B\t\r\n\p{White_Space}] -> skip;
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;