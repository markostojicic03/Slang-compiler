package org.example.slang.ast;


import java.util.ArrayList;
import java.util.List;

public class ArgumentList extends Statement{
    private final List<Argument> arguments;

    public ArgumentList(Location location, List<Argument> arguments) {
        super(location);
        this.arguments = new ArrayList<>(arguments);
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("ArgumentList", () -> {
            for (Argument arg : arguments) {
                arg.prettyPrint(pp);
            }
        });
    }
}
