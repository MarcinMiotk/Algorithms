package net.keinesorgen.puzzle.java.arrays;

/**
 *
 */
public class ArraysPuzzle {

    public void length() {
        int[] a = new int[0];
        System.out.println(a.length);
    }

    public void lengthMinus() {
        int[] a = new int[-1];
        System.out.println(a.length);
    }

    public void sumBytes() {
        byte a = 25;
        byte b = 45;
        byte result = (byte) (a + b);
        System.out.println("sumBytes="+result);
    }

    public static void main(String[] args) {
        ArraysPuzzle testing = new ArraysPuzzle();
        testing.length();
        try {
            testing.lengthMinus();
        } catch (java.lang.NegativeArraySizeException ex) {
            System.err.println("Occured exception and it's good. " + ex);
        }
        testing.sumBytes();
    }
}
