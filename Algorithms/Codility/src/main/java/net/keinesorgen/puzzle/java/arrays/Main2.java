package net.keinesorgen.puzzle.java.arrays;

/**
 *
 */
public class Main2 {

    public static void main(String[] args) {
        if (args.length == 1 | args[1].equals("debug")) {
            System.out.println(args[0]);
        } else {
            System.out.println("Release");
        }
    }

}
