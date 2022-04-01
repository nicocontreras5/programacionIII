package grafo;

import java.util.Iterator;

public class IteratorAdyacentes<T> implements Iterator<Integer> {

    private Iterator<Arco<T>> itereatorArcos;

    public IteratorAdyacentes(Iterator<Arco<T>> itereatorArcos) {
        this.itereatorArcos = itereatorArcos;
    }

    @Override
    public boolean hasNext() {
        return itereatorArcos.hasNext();
    }

    @Override
    public Integer next() {
        return itereatorArcos.next().getVerticeDestino();
    }
}
