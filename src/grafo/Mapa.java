package grafo;

import java.util.HashMap;
import java.util.Iterator;

public class Mapa {
    private Grafo<Integer> grafo;
    private HashMap<Integer, Ciudad> ciudades;

    public Mapa() {
        this.grafo = new GrafoNoDirigido<>();
        this.ciudades = new HashMap<>();
    }


    //O(1)
    public void addRuta(Ciudad origen, Ciudad destino, Integer km) {
        this.grafo.agregarArco(origen.getIdCiudad(), destino.getIdCiudad(), km);
    }
    // Complejidad: O(v*a) a = cantidad de rutas y v = cantidad de ciudades
    public void deleteRuta(Ciudad origen, Ciudad destino) {
        this.grafo.borrarArco(origen.getIdCiudad(), destino.getIdCiudad());
    }

    public Camino getCaminoMasCorto(int ciudadOrigen, int ciudadDestino) {
        Dfs dfs = new Dfs(this);
        return dfs.dfs(ciudadOrigen, ciudadDestino);
    }

    //O(1)
    public Ciudad getCiudad(Integer pos) {
        return this.ciudades.get(pos);
    }

    //O(a)  a = cantidad de rutas
    public Integer obtenerKm(int verticeOrigen, int verticeDestino) {
        return grafo.obtenerArco(verticeOrigen, verticeDestino).getEtiqueta();
    }

    //O(v*a) a = cantidad de rutas y v = cantidad de ciudades
    public Iterator<Integer> obtenerAdyacentesCiudad(int ciudad) {
        return this.grafo.obtenerAdyacentes(ciudad);
    }
    //O(1)
    public Iterator<Integer> getCiudades() {
        return this.grafo.obtenerVertices();
    }
    //O(1)
    public void addCiudad(Ciudad ciudad) {
        this.ciudades.put(ciudad.getIdCiudad(), ciudad);
        this.grafo.agregarVertice(ciudad.getIdCiudad());
    }
    // Complejidad: O(v*a) a = cantidad de rutas y v = cantidad de ciudades
    public void deleteCiudad(Ciudad ciudad) {
        this.grafo.borrarVertice(ciudad.getIdCiudad());
        this.ciudades.remove(ciudad.getIdCiudad());
    }
}
