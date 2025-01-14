package org.example.slang.ast;

public class ReturnStatement extends Statement {

    private Expression value;

    public ReturnStatement(Location location, Expression expression) {
        super(location);
        this.value = expression;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("ReturnStatement", () -> {
            if (value != null) {
                pp.node("value", () -> value.prettyPrint(pp));
            } else {
                pp.terminal("value: null");
            }
        });
    }
}
