package org.example.slang.slang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import slang.parser.SlangLexer;

public class Scanner {
    private final Slang compiler;

    public Scanner(Slang compiler) {
        this.compiler = compiler;
    }

    public Lexer getTokens(CharStream chars) {
        var lex = new SlangLexer(chars);
        lex.removeErrorListeners();
        lex.addErrorListener(compiler.errorListener());
        return lex;
    }
}
