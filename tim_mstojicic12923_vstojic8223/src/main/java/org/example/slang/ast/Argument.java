package org.example.slang.ast;

public class Argument extends Statement {
    private final PrimitiveType type;
    private final String identifier;

    public Argument(Location loc, PrimitiveType type, String identifier) {
        super(loc);
        this.type = type;
        this.identifier = identifier;

    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("Argument", () -> {
            pp.terminal("%s %s".formatted(type.getType().getStringRepresentation(), identifier));
        });
    }
}
