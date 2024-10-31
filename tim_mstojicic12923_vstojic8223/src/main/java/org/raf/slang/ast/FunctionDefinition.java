package org.raf.slang.ast;

import java.util.List;

public class FunctionDefinition extends Statement{


    private String name;
    private List<Expr> arguments;


    public FunctionDefinition(Location location, String name, List<Expr> arguments) {
        super(location);
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public void nodePrint(ASTNodePrinter functionDefinitionPrint) {
        functionDefinitionPrint.node("function definition " + name, () -> arguments.forEach(x -> x.nodePrint(functionDefinitionPrint)));
    }
}
