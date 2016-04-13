package net.keinesorgen.puzzle.java.collections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Foo {

    Integer code;

    Foo(Integer c) {
        code = c;
    }

    public boolean equals(Foo f) {
        return false;
    }

    public boolean equals(Set f) {
        return false;
    }

    public boolean equals(HashSet f) {
        return false;
    }

    @Override
    public boolean equals(Object f) {
        return true;
    }

    public int hashCode() {
        return 17;
    }
}
