package lista;

import java.util.Iterator;

public class MyIterator  implements Iterator<Integer> {
    private Node cursor;

    public MyIterator(Node first) {
        this.cursor = first;
    }
    // bigO metodo hasNext O(1)
    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    // bigO metodo next O(1)
    @Override
    public Integer next() |||||||||||||{
        Integer info = this.cursor.getInfo(); //O(1)
        this.cursor = this.cursor.getNext(); // O(1)

        return info;
    }

    // bigO metodo get O(1)
    public Integer get() {
        return this.cursor.getInfo();
    }

    // bigO metodo move O(1)
    public void move() {
        this.cursor = this.cursor.getNext();
    }
}
