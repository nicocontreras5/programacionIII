package entregable_4_5;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;

    public Empresa(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void  crearGruposDeTrabajoGreedy(ArrayList<Empleado> empleados){

        GreedyGruposTrabajo greedy = new GreedyGruposTrabajo(empleados);
        greedy.crearGrupos();

    }



    public void  crearGruposDeTrabajoBack(ArrayList<Empleado> empleados){

        BacktrackingGruposTrabajo Algoritmoback = new BacktrackingGruposTrabajo(empleados);
        Algoritmoback.back();

    }


}
