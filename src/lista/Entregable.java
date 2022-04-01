package lista;

import java.util.Iterator;

public class Entregable {
    private MySimpleLinkedList lista;
    private Integer umbral;

    public Entregable(MySimpleLinkedList lista, Integer umbral) {
        this.lista = lista;
        this.umbral = umbral;
    }

    // bigO metodo getSubsecuenciasList O(n) n = es la cantidad de elementos de la lista
    public MySimpleLinkedList getSubsecuenciasList() {
        MySimpleLinkedList aux = new MySimpleLinkedList();
        Iterator<Integer> it = this.lista.iterator();

        int total = 0;
        int suma = 0;

        while(it.hasNext()) { // O(n) n = es la cantidad de elementos de la lista
            suma = it.next();


            if ((total+suma >umbral)&&(suma != total+suma)){
                if (total <= umbral){
                    aux.insertBack(total); // O(1)
                    total = suma;
                }else
                    total= 0;

            }
            else if (total+suma<=umbral)
                total += suma;

        }

        if (total <= umbral && total != 0)
            aux.insertBack(total);// O(1)
        return aux;
    }

}
