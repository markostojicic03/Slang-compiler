package org.example.slang.ast;

public class BreakStatement extends Statement {

    public BreakStatement(Location location) {
        super(location);
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.terminal("break");
    }
}
