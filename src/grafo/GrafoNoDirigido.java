package grafo;

public class GrafoNoDirigido<T>  extends GrafoDirigido<T>{
    //O(1)
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        super.agregarArco(verticeId1, verticeId2, etiqueta);
        super.agregarArco(verticeId2, verticeId1, etiqueta);
    }
    //O(v*a) v = vandidad de vertices a = cantidad de arcos
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        super.borrarArco(verticeId1, verticeId2);
        super.borrarArco(verticeId2, verticeId1);
    }

}
