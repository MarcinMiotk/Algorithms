package skeleton;

public class Node {
    Node left;
    Node right;
    int info;
    int balance;

    Node(int info) {
        this.info = info;
        this.balance = 0;
        this.left = null;
        this.right = null;
    }
}
