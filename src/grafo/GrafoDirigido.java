package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap <Integer, ArrayList<Arco<T>>> vertices;
    private  int cantArcos;

    public GrafoDirigido() {
        this.vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
        cantArcos = 0;
    }

    // Complejidad: O(1)
    @Override
    public void agregarVertice(int verticeId) {
        if ( !contieneVertice(verticeId)) // O(1)
            this.vertices.put(verticeId, new ArrayList<Arco<T>>()); // O(1)
    }


    // Complejidad: O(v*a) a = cantidad de arcos y v = cantidad de vertices
    @Override
    public void borrarVertice(int verticeId) {
        if (contieneVertice(verticeId)) { //O(1)
            cantArcos -= this.vertices.get(verticeId).size();
            this.vertices.remove(verticeId);
            Iterator<ArrayList<Arco<T>>> itArcosVertices = this.vertices.values().iterator();
            while (itArcosVertices.hasNext()){ //O(V) v = cantidad de vertices
                Iterator<Arco<T>> itArcos = itArcosVertices.next().iterator();
                while (itArcos.hasNext()){//O(a) a = cantidad de arcos de cada vertice
                    if (itArcos.next().getVerticeDestino() == verticeId){
                        //it.remove borra la posiciona actual en la que estoy parado en el iterador
                        itArcos.remove();
                        cantArcos--;
                    }
                }
            }

        }
    }







    // Complejidad: O(a)
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (contieneVertice(verticeId1)&& contieneVertice(verticeId2)) { // O(a)
            Arco<T> arco = new Arco(verticeId1, verticeId2, etiqueta);
            this.vertices.get(verticeId1).add(arco); // O(1)
            cantArcos ++;
        }
    }

    // Complejidad: O(a)  a = cantidad de arcos del verticeid1
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {

        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)){ // O(1)
            Iterator<Arco<T>> it = obtenerArcos(verticeId1);
            while (it.hasNext()){  //O(a) a = arcos de un vertice
                Arco<T> arco = it.next();
                if (arco.getVerticeDestino() == verticeId2){
                    cantArcos--;
                    it.remove();
                }
            }
        }


    }

    // Complejidad: O(1)
    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    // Complejidad: O(a) a = cantidad de arcos
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
       if (contieneVertice(verticeId1) && contieneVertice(verticeId2)){
           Arco<T> arco = this.obtenerArco(verticeId1, verticeId2); // Complejidad: O(a)
           return arco != null;
       }else
           return false;
    }

    // Complejidad: O(a)  a = cantidad de arcos
    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) { // O(1)
            Iterator<Arco<T>> it = obtenerArcos(verticeId1); // O(1)
            while (it.hasNext()) { // O(a) a = cantidad de arcos
                Arco<T> arco = it.next(); // O(1)
                if (arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
            }
        }
        return null;
    }

    // Complejidad: O(1)
    @Override
    public int cantidadVertices() {
        return this.vertices.size(); // O(1)
    }

    // Complejidad: O(1)
    @Override
    public int cantidadArcos() {
        return cantArcos;
    }

    // Complejidad: O(1)
    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    // Complejidad: O(1)  debido a la implementacion de la clase IteradorAdyacentes como se realizo en la practica
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
       Iterator<Arco<T>> it = this.vertices.get(verticeId).iterator();
        return new IteratorAdyacentes<T>(it);
    }

    // Complejidad: O(v*a) v = cantidad ed vertices y a = cantidad de arcos
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        Iterator<Integer> it = obtenerVertices(); // O(1)
        ArrayList<Arco<T>> arcos = new ArrayList<>();

        while (it.hasNext()) { // O(v) v = cantidad de vértices
            Integer vertice = it.next(); // O(1)
            arcos.addAll(this.vertices.get(vertice)); // O(a) a = cantidad de arcos
        }
        return arcos.iterator();
    }



    // Complejidad: O(1)
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        if (contieneVertice(verticeId))
            arcos = this.vertices.get(verticeId);
        return arcos.iterator();
    }
}
