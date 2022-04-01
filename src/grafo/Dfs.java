package grafo;

import java.util.HashMap;
import java.util.Iterator;

public class Dfs {

    private HashMap<Integer,String> colores;
    private Mapa mapa;
    public int i;

    public Dfs(Mapa mapa) {
        this.mapa = mapa;
        this.colores = new HashMap<>();

    }

    public Camino dfs(int verticeOrigen, int verticeDestino) {
        Iterator<Integer> it = this.mapa.getCiudades();
        while (it.hasNext()) {
            Integer vertice = it.next();
            colores.put(vertice, "Blanco");
        }
        int cantidadKm = 0;
        int cantidadBalanzas = 0;
        return dfs_visit(verticeOrigen, verticeDestino, cantidadKm, cantidadBalanzas);

    }

    public Camino dfs_visit( int verticeActual, int verticeDestino, int cantKm, int cantBalanzas) {

       if (cantKm!= 0 && this.mapa.getCiudad(verticeActual).isTieneBalanza() ) {
          cantBalanzas++;
       }


        Camino caminoMasCorto = new Camino();

        if (verticeActual == verticeDestino && cantBalanzas <= 1 ) {

            caminoMasCorto.addCiudad(cantKm, this.mapa.getCiudad(verticeActual).getNombre());

        } else {
            this.colores.put(verticeActual, "Amarillo");

            Iterator<Integer> it = this.mapa.obtenerAdyacentesCiudad(verticeActual);


            while (it.hasNext() && cantBalanzas <= 1  ) {
                Integer adyacente = it.next();

                if (this.colores.get(adyacente).equals("Blanco")) {

                    cantKm += this.mapa.obtenerKm(verticeActual, adyacente);
                        Camino camino = dfs_visit(adyacente, verticeDestino, cantKm, cantBalanzas);
                        camino.addCiudadActual(this.mapa.getCiudad(verticeActual).getNombre());
                        if(camino.contiene(this.mapa.getCiudad(verticeDestino).getNombre()) && camino.getCantidadKm() < caminoMasCorto.getCantidadKm()
                                || caminoMasCorto.getCantidadKm() == 0) {
                            caminoMasCorto = camino;

                        }
                    cantKm -= this.mapa.obtenerKm(verticeActual, adyacente);
                    //podo la rama si los km recorridos ya superan mis


                }
            }

            this.colores.put(verticeActual, "Blanco");
        }

        if (!caminoMasCorto.contiene(this.mapa.getCiudad(verticeDestino).getNombre()))
            caminoMasCorto = new Camino();


        return caminoMasCorto;
    }
}
