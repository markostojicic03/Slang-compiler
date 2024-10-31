package org.raf.slang.ast;




public class VariableRef extends Expr{
    String variableName;

    public VariableRef(Location location,String variableName) {
        super(location);
        this.variableName = variableName;
    }

    @Override
    public void nodePrint(ASTNodePrinter pp) {
        pp.node("variable", () -> pp.terminal(variableName));
    }
}
