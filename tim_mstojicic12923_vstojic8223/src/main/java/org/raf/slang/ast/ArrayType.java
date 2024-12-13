package org.raf.slang.ast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArrayType implements Type{
    private Type type;
    public ArrayType(Type type) {
        this.type = type;
    }

    @Override
    public String userReadableName() {
        /* number[] for instance.  */
        return type.userReadableName() + "[]";
    }
}
