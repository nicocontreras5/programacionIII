package prog3_22;

public class ElementosComunesListas<T extends Comparable<T>> {
    private MySimpleLinkedList<T> lista1;
    private MySimpleLinkedList<T> lista2;

    public ElementosComunesListas(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        this.lista1 = l1;
        this.lista2 = l2;
    }


    public MySimpleLinkedList<T> desordenados (){
        MySimpleLinkedList<T> auxList = new MySimpleLinkedList<>();
        MyIterator<T> it1 = this.lista1.iterator();
        MyIterator<T> it2 = this.lista2.iterator();
        boolean encontro = false;

        while (it1.hasNext()){
            encontro = false;
            while (it2.hasNext() && !encontro){
                if (it1.get() == it2.get()){
                    encontro = true;
                    auxList.insertFront(it2.get());
                }else{
                    it2.move();
                }
            }

            it2 = lista2.iterator();
            it1.move();
        }
        System.out.println("lista desordenada " +auxList);
        return  this.ordenar(auxList);

    }

    public MySimpleLinkedList<T> ordenar (MySimpleLinkedList<T> desordenados){
        MySimpleLinkedList<T> ordenados = new MySimpleLinkedList<>();
        MyIterator<T> itDesordenados = desordenados.iterator();
        ordenados.insertFront(itDesordenados.get());
        MyIterator<T> itOrdenados = ordenados.iterator(); // O (1)
        itDesordenados.move();
        while (itDesordenados.hasNext()){

            if (itDesordenados.get().compareTo(itOrdenados.get()) == -1){
                ordenados.insertFront(itDesordenados.get());
                itOrdenados = ordenados.iterator(); // O (1)

            }else if (itOrdenados.get().compareTo(itDesordenados.get()) == -1){
                int poss =-1;
                boolean encontroPos = false;

                while (itOrdenados.hasNext() && !encontroPos){
                   if(itOrdenados.get().compareTo(itDesordenados.get() )== -1){

                       poss++;
                       itOrdenados.move();
                   }else{
                       encontroPos = true;
                   }
                }

                ordenados.insertIndex(poss,itDesordenados.get());
                itOrdenados = ordenados.iterator();
            }
            itDesordenados.move();
        }

        return ordenados;
    }


    public static void main(String[] args) {

        MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();

        list1.insertFront(25);

        list1.insertFront(3);
        list1.insertFront(2);
        list1.insertFront(4);
        list2.insertFront(20);
        list1.insertFront(38);
        list2.insertFront(2);
        list1.insertFront(100);
        list2.insertFront(100);

        list2.insertFront(38);
        list2.insertFront(20);

        list2.insertFront(25);
        list2.insertFront(3);
        list2.insertFront(30);

        System.out.println("lista  1: " +list1);
        System.out.println("lista  2: " +list2);
        ElementosComunesListas<Integer> eje6 =new ElementosComunesListas<>(list1,list2);

        System.out.println(eje6.desordenados());

    }


    }

