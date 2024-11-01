package org.raf.slang.ast;

import java.util.List;
import java.util.Objects;

public class ElseStatement extends Statement{

    public ElseStatement(Location location) {
        super(location);
    }

    @Override
    public void nodePrint(ASTNodePrinter printElseStatement) {
        printElseStatement.node("else", () -> printElseStatement.terminal("else"));
    }
}
