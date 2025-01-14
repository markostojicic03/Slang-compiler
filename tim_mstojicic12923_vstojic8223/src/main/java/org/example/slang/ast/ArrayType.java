package org.example.slang.ast;

public class ArrayType extends Expression {
    private final PrimitiveType baseType;

    public ArrayType(Location location, PrimitiveType baseType) {
        super(location);
        this.baseType = baseType;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("ArrayType", () -> {
            baseType.prettyPrint(pp);
        });
    }
}