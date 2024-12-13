package org.raf.slang.ast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberType implements Type {
    private Type type;
    public NumberType(Type type) {
        this.type = type;
    }


    @Override
    public String userReadableName() {
        return "number";
    }
}
