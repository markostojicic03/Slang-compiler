package org.example.slang.ast;

public class ContinueStatement extends Statement{

    public ContinueStatement(Location location) {
        super(location);
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.terminal("continue");
    }
}
