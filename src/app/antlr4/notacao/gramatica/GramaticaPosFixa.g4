/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
grammar GramaticaPosFixa;

@header {
    package app.antlr4.notacao.gramatica;
}
expr returns[String posfixa]
    :   e1=expr op=(MUL|DIV) e2=expr {$posfixa = $e1.posfixa + $e2.posfixa + $op.text;} #MulDiv
    |   e1=expr op=(ADD|SUB) e2=expr {$posfixa = $e1.posfixa + $e2.posfixa + $op.text;} #AddSub
    |   INT                          {$posfixa = $INT.text;}                            #int
    |   DOUBLE                       {$posfixa = $DOUBLE.text;}                         #double
    |   '(' expr ')'                 {$posfixa = $expr.posfixa;}                        #parens
    ;

INT    :   [0-9]+;
DOUBLE :   [0-9]+'.'[0-9]+;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
WS  : ' ' -> skip;