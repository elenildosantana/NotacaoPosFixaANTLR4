/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.antlr4.notacao.modelo;

import app.antlr4.notacao.gramatica.GramaticaPosFixaLexer;
import app.antlr4.notacao.gramatica.GramaticaPosFixaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author nildo
 */
public class NotacaoPosFixa {

    private final String expressao;

    public NotacaoPosFixa(String expressao) {
        this.expressao = expressao;
    }

    public String getNotacaoPosfixa() {
        ANTLRInputStream inputStream = new ANTLRInputStream(this.expressao);
        GramaticaPosFixaLexer lexer = new GramaticaPosFixaLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GramaticaPosFixaParser parser = new GramaticaPosFixaParser(tokenStream);
        String notacaoPosFixa = parser.expr().posfixa;
        return notacaoPosFixa;
    }

    public String getExpressao() {
        return expressao;
    }

}
