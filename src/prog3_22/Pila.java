package prog3_22;

public class Pila<T extends Comparable<T>> {
    private MySimpleLinkedList<T> elementos;

    public Pila() {
        this.elementos = new MySimpleLinkedList();
    }

    public void push(T info){
        this.elementos.insertFront(info);

    }

    public T pop(){
        return this.elementos.extractFront();

    }

    public T top(){
        return this.elementos.get(1);
    }

    public void reverse(){
                //hacer ocn iterador
                MySimpleLinkedList<T> auxList = new MySimpleLinkedList<>();
                while(this.elementos.size() >0){
                    auxList.insertFront(this.elementos.extractFront());
                }
                this.elementos = auxList;
    }


}
