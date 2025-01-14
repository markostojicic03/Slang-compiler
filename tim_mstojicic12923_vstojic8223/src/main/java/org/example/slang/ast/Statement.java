package org.example.slang.ast;

/** Base class for all statements.  */
public abstract class Statement extends Tree {
    public Statement(Location location) {
        super(location);
    }
}