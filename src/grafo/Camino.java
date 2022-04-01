package grafo;

import java.util.ArrayList;

public class Camino {

    private ArrayList<String> ciudades;
    private int km;

    public Camino() {
        this.ciudades = new ArrayList<String>();
        this.km = 0;
    }
    //O(1)
    public int getCantidadKm() {
        return this.km;
    }

    //O(1)
    public void addCiudad(Integer km, String ciudad) {
        this.ciudades.add(ciudad);
        this.km = km;
    }
    //O(1)
    public void addCiudadActual(String ciudad) {
        this.ciudades.add(0, ciudad);
    }
    //O(c) c = cantidad de ciudades del camino
    public boolean contiene(String ciudad) {
        for(String c : this.ciudades) {
            if (c.equals(ciudad)) {
                return true;
            }
        }
        return false;
    }
    //O(1)
    public String toString() {
        if (!this.ciudades.isEmpty())
            return "Recorrido: " + this.ciudades + " Cantidad de KM: " + this.getCantidadKm();
        return "No existe camino aceptable";
    }
}
