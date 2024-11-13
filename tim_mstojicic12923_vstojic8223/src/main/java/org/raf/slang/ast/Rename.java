package org.raf.slang.ast;

import java.util.Objects;

public class Rename extends Statement{
    private String variable;
    private String variableReplace;
    public Rename(Location location, String variable, String variableReplace) {
        super(location);
        this.variable = variable;
        this.variableReplace = variableReplace;
    }

    @Override
    public void nodePrint(ASTNodePrinter pp) {
        pp.node("rename", () -> pp.terminal(Objects.toString(variableReplace)));
    }
}
