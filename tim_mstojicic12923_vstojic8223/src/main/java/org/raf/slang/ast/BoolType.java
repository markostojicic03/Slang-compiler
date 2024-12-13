package org.raf.slang.ast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoolType implements Type{
    private Type type;
    public BoolType(Type type) {
        this.type = type;
    }


    @Override
    public String userReadableName() {
        return "boolean";
    }
}
