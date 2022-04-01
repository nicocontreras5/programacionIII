package entregable_4_5;

import java.util.ArrayList;

public class GrupoTrabajo {
    private String nombre;
    private ArrayList<Empleado> integrantes;
    private int fuerzaDeTrabajo = 0;



    public GrupoTrabajo getCopiaGrupo(){
        GrupoTrabajo aux = new GrupoTrabajo(this.nombre);
        for (Empleado e: this.getIntegrantes()) {
            aux.addIntegrante(e);
        }
        return aux;
    }



    public GrupoTrabajo(String nombre) {
        this.integrantes = new ArrayList<Empleado>();
        this.fuerzaDeTrabajo = 0;
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getIntegrantes() {
        return integrantes;

    }

    public void addIntegrante(Empleado e) {
        this.integrantes.add(e);
        this.fuerzaDeTrabajo += e.getFuerzaDeTrabajo();
    }

    public int getFuerzaDeTrabajo() {
        return fuerzaDeTrabajo;
    }

    @Override
    public String toString() {

        return this.nombre + " " + this.integrantes + " fuerza de trabajo " + this.fuerzaDeTrabajo;
    }

    public void deleteIntegrante(Empleado e) {
        this.integrantes.remove(e);
        this.fuerzaDeTrabajo -= e.getFuerzaDeTrabajo();
    }
}
