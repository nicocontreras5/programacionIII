package grafo;

public class MainMapa {
    public static <T> void main(String[] args) {
        Ciudad rauch = new Ciudad(4, "Rauch", false, true, 1, 0);
        Ciudad pehuajo = new Ciudad(1, "Pehuajo", true, true, 3, 5);
        Ciudad ayacucho = new Ciudad(2, "Ayacucho", false, false, 1, 2);
        Ciudad olavarria = new Ciudad(3, "Olavarria", true, false, 9, 17);
        Ciudad tandil = new Ciudad(6, "Tandil", true, true, 6, 4);
        Ciudad bolivar = new Ciudad(5, "Bolivar", false, false, 7, 4);
        Ciudad mardel = new Ciudad(8, "MarDelPlata", true,false,15,12);
        Ciudad azul = new Ciudad(7, "Azul", false, true, 4, 4);

        Mapa mapa = new Mapa();
        mapa.addCiudad(pehuajo);
        mapa.addCiudad(ayacucho);
        mapa.addCiudad(olavarria);
        mapa.addCiudad(rauch);
        mapa.addCiudad(bolivar);
        mapa.addCiudad(tandil);
        mapa.addCiudad(azul);
        mapa.addCiudad(mardel);

        mapa.addRuta(pehuajo, ayacucho, 540);
        mapa.addRuta(pehuajo, bolivar, 70);
        mapa.addRuta(ayacucho, rauch, 50);
        mapa.addRuta(ayacucho, tandil, 70);
        mapa.addRuta(olavarria, rauch, 210);
        mapa.addRuta(olavarria, bolivar, 140);
        mapa.addRuta(olavarria, tandil, 130);
        mapa.addRuta(rauch, tandil, 60);
        mapa.addRuta(bolivar, azul, 100);
        mapa.addRuta(tandil, mardel, 200);

        System.out.println(mapa.getCaminoMasCorto(7, 2));
        System.out.println(mapa.getCaminoMasCorto(4, 8));
        System.out.println(mapa.getCaminoMasCorto(8, 1));
        mapa.deleteCiudad(ayacucho);
        mapa.deleteRuta(tandil, rauch);
        System.out.println(mapa.getCaminoMasCorto(8, 1));

    }    
}
