package arbol;

public class TreeNode {
    private int value;
    private TreeNode izq;
    private TreeNode der;


    public TreeNode(int value) {
        this.value = value;
        this.izq = null;
        this.der = null;
    }

    //complejidad:  big O O(1)
    public int getValue() {
        return this.value;
    }


    //complejidad:  big O O(1)
    public void setValue(int value) {
        this.value = value;
    }

    //complejidad:  big O O(1)
    public TreeNode getIzq() {
        return this.izq;
    }

    //complejidad:  big O O(1)
    public TreeNode getDer() {
        return this.der;
    }

    //complejidad:  big O O(1)
    public void setIzq(TreeNode node) {
        this.izq = node;
    }

    //complejidad:  big O O(1)
    public void setDer(TreeNode node) {
        this.der = node;
    }

    //complejidad:  big O O(1)
    public String toString() {
        return "" + this.getValue();
    }
}
