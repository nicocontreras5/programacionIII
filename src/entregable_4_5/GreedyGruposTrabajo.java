package entregable_4_5;

import java.util.ArrayList;

public class GreedyGruposTrabajo {
    private Solucion solucion;
    private ArrayList<Empleado> candidatos;

    public GreedyGruposTrabajo(ArrayList<Empleado> candidatos) {
        this.solucion = new Solucion();
        this.candidatos= new ArrayList<Empleado>(candidatos);
    }

    // criteriom seleccion: en cada paso elijo el empleado cuya  fuerzaDeTrabajo
    // esta mas proximo a la resta entre la fuerzaDeTRabajo del grupo1 menos la fuerzaDeTRabajo del grupo2
    //candidatos [ e1: 30, e2: 43, e3: 78, e4: 58 ] grupo1 = 40 grupo2= 60 diferenciaFuerzas = 60-40 = 20;
    //candidato elegido = e1; tiene la fuerza(30) mas proxima a 20;


    public void crearGrupos(){

        int i = 0;
        while (candidatos.size()>0){
            //selecciono
            Empleado e = this.seleccionar();
            //this.solucion
            this.solucion.agregarEmmpleadoGrupoMenor(e);
            candidatos.remove(e);
            i++;
        }

        System.out.println(this.solucion);
        System.out.println("\tCantidad de iteraciones " + i);


    }


    public Empleado seleccionar(){
            int i= 0;
            int diferenciaFuerzaGrupos =this.solucion.getDiferenciaGrupos();
            int mejorFuerza = -1;
            Empleado mejorEmpleado = null;
            for (Empleado e: candidatos) {
                int fuerzaAux = e.getFuerzaDeTrabajo();

                if (fuerzaAux-diferenciaFuerzaGrupos > mejorFuerza-diferenciaFuerzaGrupos  || mejorFuerza ==-1){
                    mejorFuerza= fuerzaAux;
                    mejorEmpleado = e;

                }
            }


            return mejorEmpleado;
    }


}
