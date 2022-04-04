package prog3_22;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Integer size;
    private Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
        this.size= 0;


    }

    //O(1) -- array O(n) siendo n cantidad de ementos en el array
    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    //O(1) -- array O(n) siendo n cantidad de ementos en el array
    public T extractFront() {
        if (this.first != null){
            Node<T> temp = this.first;
            this.first = temp.getNext();
            this.size--;
            return temp.getInfo();
        }
        return null;
    }

    public boolean isEmpty() {
        //return this.size==0;
        return this.first == null;
    }

    //array O(1) -- lista O(n) siendo n cantidad de ementos en el array
    public T get(int index) {
        if (index > this.size || index<1){
            return null;
        }
        else{
            int pos = 1;
            MyIterator<T> it = this.iterator();
             while (pos != index && it.hasNext()){
                 pos++;
                 it.move();
             }
             return it.get();
        }
    }

    public int indexOf(T elem){
        if (this.isEmpty()){
            return -1;
        }
        else{
            int pos = 1;
            MyIterator<T> it = this.iterator();
            while (it.get() != elem && it.hasNext()){
                pos++;
                it.move();
            }
            return pos;
        }
    }

    //O(1) -- array O(1)
    public int size() {

        return this.size;
    }

    public void insertIndex(int index, T info ){
        if (this.size > index){
            Node<T> nuevo = new Node<T>(info,null);
            Node<T> current = this.first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            nuevo.setNext(current.getNext());
            current.setNext(nuevo);
            this.size++;
        }

    }

    @Override
    public String toString() {
        MyIterator<T> it = this.iterator();
        String valor = "";
        while (it.hasNext()){
            valor+= " | "+ it.next();
        }
        valor += "";
        return valor + " |";
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator(this.first);
    }


}