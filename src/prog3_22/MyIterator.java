package prog3_22;

import java.util.Iterator;

public class MyIterator<T extends Comparable<T>> implements Iterator<T> {
    private Node<T> cursor;

    public MyIterator(Node<T> first){
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }


    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor= this.cursor.getNext();
        return info;
    }

    public T getNext(){
        return  this.cursor.getNext().getInfo();
    }

    public boolean havenext(){
        return this.cursor.getNext() != null;
    }

    public void setCursor(Node<T> f){
        this.cursor = f;
    }

    public void move(){
        this.cursor = this.cursor.getNext();
    }


    public T get(){
        return this.cursor.getInfo();
    }
}
