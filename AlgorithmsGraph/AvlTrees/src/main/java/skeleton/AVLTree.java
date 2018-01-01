package skeleton;


import static java.lang.System.out;

public class AVLTree {
    private Node root;
    static boolean taller;          // used in insertion and deletion
    static boolean shorter;         // used in insertion and deletion

    AVLTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root==null);
    }

    void display() {
        display(root, 0);
        out.println();
    }

    void display(Node node, int level) {
        int i;
        if(node==null) {
            return;
        }

        display(node.right, level+1);
        out.println();

        for(i=0; i<level; i++) {
            out.println("   ");
        }
        out.println(node.info);

        display(node.left, level+1);
    }

    void inorder() {
        inorder(root);
        out.println();
    }

    void inorder(Node node) {
        if(node==null) {
            return;
        }
        inorder(node.left);
        out.print(node.info+" ");
        inorder(node.right);
    }

    void insert(int x) {
        root = insert(root, x);
    }

    Node insert(Node candidate, int x) {

    }


}
