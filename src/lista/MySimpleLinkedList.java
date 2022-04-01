package lista;

public class MySimpleLinkedList implements Iterable<Integer> {
    private Node first;
    private Node last;
    private Integer size;

    public MySimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    // bigOn del metodo insertFront O(1)
    public void insertFront(int o) {
        Node tmp = new Node(o, null ,null);
        if (first != null){
           tmp.setNext(this.first);
        }else
            this.last = tmp;
        this.first = tmp;

		this.size++;
	}

// bigOn del metodo insertBack O(1)
    public void insertBack(Integer o) {
        Node tmp = new Node(o,null,null);
        if (this.last!= null){
            tmp.setBack(this.last);
            this.last.setNext(tmp);

        }
        this.last = tmp;
        if (this.first == null){
            this.first = tmp;
        }
        this.size++;

    }

    // bigO metodo toString O(n) n = es la cantidad de elementos de la lista.
    @Override
    public String toString() {
         MyIterator it = this.iterator();
         String valor = " [";
        while (it.hasNext()){  //O(n)  n = la cantidad de elementos de la lista.
           valor +=  " " + it.next(); // O(1)

        };
        return valor+= " ] ";
    }

    // bigO del metodo exctratFront O(1)
    public Integer extractFront() {
        if (this.first!= null){
            Integer aux = this.first.getInfo();
            this.first = this.first.getNext();
            this.size --;
            return aux;
        }
        else
            return null;
    }

    // bigO del metodo isEmpty O(1)
    public boolean isEmpty() {

        return this.first == null;
    }

    //bigO del metodo get O(n) n = es la cantidad de elementos de la lista. En el peor de los casos el elemento pedido  es el ultimo de la lista.
    public Integer get(int index) {

        MyIterator it = this.iterator();
        Integer aux = 0;
        if (index < this.size) {
            while (it.hasNext() && (index !=aux)){ // hasnext O(1)
                aux++;
                it.move(); // O(1)
            }
            if (index== aux)
                return  it.get(); // O(1)
            else
                return null;
        }
        else
            return null;



    }

    // bigO size O(1)
    public int size() {

        return this.size;
    }

    //bigO del metodo indexOf O(n) n = es la cantidad de elementos de la lista. En el peor de los casos el elemento buscado es el ultimo de la lista.
    public Integer indexOf(int n) {
        int pos = 0;
        MyIterator it = this.iterator();
        while (it.hasNext() && it.get()!= n){ // while O(n) // it.get = O (1)
            it.move();
            pos++;

        }
        if (it.hasNext())
            return  pos;
        else
            return -1;
    }

    //bigO del metodo print  O(n) n = es la cantidad de elementos de la lista. En el peor de los casos imprime toda la lista
    public void print(int n) { // O(n) n = es la cantidad de elementos de la lista
        int pos = 0;
        if ((n<this.size)&&(n >0)){
            MySimpleLinkedList aux = new MySimpleLinkedList();
            MyIterator it = this.iterator();
            while (it.hasNext() && pos <= n){ // while O(n)  // hasnext O(1)
                aux.insertBack(it.next());  // O(1)
                pos++;

            }
            System.out.println(aux);
        }


    }

    @Override
    public MyIterator iterator() {
        return new MyIterator(this.first);
    }
}
