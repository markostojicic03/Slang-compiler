package org.raf.slang.ast;

import java.util.List;

public class FunctionDefinition extends Statement{


    private String name;
    private List<Expr> arguments;
    private List<Statement> statementList;


    public FunctionDefinition(Location location, String name, List<Expr> arguments,List<Statement> statementList ) {
        super(location);
        this.name = name;
        this.arguments = arguments;
        this.statementList = statementList;
    }

    @Override
    public void nodePrint(ASTNodePrinter functionDefinitionPrint) {
        functionDefinitionPrint.node("function definiton", () -> {
            arguments.forEach(x -> x.nodePrint(functionDefinitionPrint));
            statementList.forEach(statement -> statement.nodePrint(functionDefinitionPrint));
        });
    }
}
