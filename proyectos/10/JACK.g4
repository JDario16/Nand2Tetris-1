grammar JACK;

KEYWORD: 'class'|'constructor'|'function'|'method'|'field'|'static'|'var'|'int'|'char'|'boolean'|'void'|'true'|'false'|'null'|'this'|'let'|'do'|'if'|'else'|'while'|'return';
SYMBOL: '{'|'}'|'('|')'|'['|']'|'.'|','|';'|'+'|'-'|'*'|'/'|'&'|'|'|'<'|'>'|'='|'~';
INTEGERCONSTANT: [0-9]+;
STRINGCONSTANT: ( '"' .*? '"');
COMMENT:  ( '//' ~[\r\n]* '\r'? '\n' | '/**' .*? '*/') -> skip;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
WS: [ \t\r\n]+ -> skip ;


classes: 'class'className'{'classVarDec* subroutineDec*'}';
classVarDec: ('static'|'field')type varName(',' varName)*';';
type: 'int'|'char'|'boolean'|className;
subroutineDec: ('constructor'|'function'|'method')('void'|type)subroutineName'('parameterList')'subroutineBody;
parameterList:((type varName)(','type varName)*)?;
subroutineBody: '{'varDec* statements'}';
varDec: 'var' type varName(',' varName)*';';
className: IDENTIFIER;
subroutineName: IDENTIFIER;
varName: IDENTIFIER;

statements:statement*;
statement:letStatement|ifStatement|whileStatement|doStatement|returnStatement;
letStatement: 'let' varName('['expression']')?'='expression';';
ifStatement: 'if''('expression	')''{'statements'}'('else''{' statements'}')?;
whileStatement: 'while''('expression')''{'statements'}';
doStatement:'do'subroutineCall';';
returnStatement: 'return' expression?';';


expression: term(op term)*;
term: INTEGERCONSTANT|STRINGCONSTANT|keywordConstant|varName|varName'['expression']'|subroutineCall|'('expression')'|unaryOP term;
subroutineCall:subroutineName'('expressionList')'|(className|varName)'.'subroutineName'('expressionList')';
expressionList: (expression(','expression)*)?;
op: '+'|'-'|'*'|'/'|'&'|'|'|'<'|'>'|'=';
unaryOP: '-'|'~';
keywordConstant: 'true'|'false'|'null'|'this';
