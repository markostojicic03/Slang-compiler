package org.example.slang.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
/** Prints values of expressions.  */
public final class PrintStatement extends Statement {
    private List<Expression> args;

    public PrintStatement(Location location, List<Expression> args) {
        super(location);
        this.args = args;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("print",
                () -> {
                    args.forEach(x -> x.prettyPrint(pp));
                });
    }
}
