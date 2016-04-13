package net.keinesorgen.puzzle.java.collections;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap tree = new TreeMap();
        tree.put("aa", 1);
        tree.put("cc", 2);
        tree.put("ee", 3);
        tree.put("gg", 4);
        NavigableMap nvMap = tree.headMap("ee", false);
        nvMap.put("nn", 5); // line 16
        System.out.println(nvMap);
    }

}
