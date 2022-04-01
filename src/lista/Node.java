package lista;

public class Node {
    private Integer info;
    private Node next;
    private Node back;

    public Node(Integer n) {
        this.info = n;
        this.next = null;
        this.back = null;
    }



    public Node(Integer o, Node n, Node b) {
        this.setInfo(o);
        this.setNext(n);
        this.setBack(b);
    }

    // O(1)
    public Node getBack() {
        return back;
    }

    // O(1)
    public void setBack(Node back) {
        this.back = back;
    }
    // O(1)
    public Node getNext() {
        return next;
    }

    // O(1)
    public void setNext(Node next) {
        this.next = next;
    }

    // O(1)
    public Integer getInfo() {
        return info;
    }

    // O(1)
    public void setInfo(Integer info) {
        this.info = info;
    }
}
