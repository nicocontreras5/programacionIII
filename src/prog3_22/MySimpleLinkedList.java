package prog3_22;

public class MySimpleLinkedList<T> {
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
            Node<T> auxNode = this.first;
             while (pos != index){
                 pos++;
                 auxNode = auxNode.getNext();
             }
             return auxNode.getInfo();
        }
    }

    public int indexOf(T elem){
        if (this.isEmpty()){
            return -1;
        }
        else{
            int pos = 1;
            Node<T> auxNode = this.first;
            while (auxNode.getInfo() != elem){
                pos++;
                auxNode = auxNode.getNext();
            }
            return pos;
        }
    }

    //O(1) -- array O(1)
    public int size() {

        return this.size;
    }

    @Override
    public String toString() {
        String lista = "lista : ";
        if (!this.isEmpty()){
            Node<T> auxNode = this.first;
            while (auxNode.getNext() != null) {

                lista+=auxNode.getInfo();
                auxNode = auxNode.getNext();
            }
        }
        return lista;
    }

}