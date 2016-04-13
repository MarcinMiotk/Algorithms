package net.keinesorgen.exceptionsScjp;

/**
 *
 */
public class ExceptionsDemo {

    public static void main(String[] args) {
        System.out.println(method());
    }

    private static String method() {
        try {
            System.out.println("TRY");
            throw new RuntimeException();
        } catch (RuntimeException ex) {
            System.out.println("CATCH");
            throw ex;
        } finally {
            System.out.println("FINALLY CATCH");
        }
    }
}
