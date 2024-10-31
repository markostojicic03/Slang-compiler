package org.raf.slang.ast;

import java.util.List;

public class LoopStatement extends Statement{

    private List<Expr> exprList;

    public LoopStatement(Location location, List<Expr> exprList) {
        super(location);
        this.exprList = exprList;
    }

    @Override
    public void nodePrint(ASTNodePrinter printLoopStatement) {
        printLoopStatement.node("loop", () -> exprList.forEach(x -> x.nodePrint(printLoopStatement)));

    }
}
