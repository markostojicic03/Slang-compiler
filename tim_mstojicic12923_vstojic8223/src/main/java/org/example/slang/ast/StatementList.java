package org.example.slang.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class StatementList extends Tree {
    private List<Statement> stmts;

    public StatementList(Location location, List<Statement> stmts) {
        super(location);
        this.stmts = stmts;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("Statements", () -> stmts.forEach (x -> x.prettyPrint(pp)));
    }
}