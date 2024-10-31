package org.raf.slang.ast;

import java.util.List;

public class ScanStatement extends Statement {

    private List<Expr> arguments;


    public ScanStatement(Location location, List<Expr> arguments) {
        super(location);
        this.arguments = arguments;
    }

    @Override
    public void nodePrint(ASTNodePrinter pp) {
        pp.node("scan", () -> arguments.forEach(x -> x.nodePrint(pp)));
    }
}