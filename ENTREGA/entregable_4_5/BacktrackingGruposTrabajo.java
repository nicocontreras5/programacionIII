package entregable_4_5;

import java.util.ArrayList;

public class BacktrackingGruposTrabajo {
    private ArrayList<Empleado> candidatos;
    private Solucion solucion;
    private int i;

    public BacktrackingGruposTrabajo(ArrayList<Empleado> candidatos) {
        this.candidatos = new ArrayList<Empleado>(candidatos);
        this.solucion = new Solucion();
        this.i = 0;
    }

    public void back() {
        this.i = 0;
        this.back(new Solucion());
        System.out.println(this.solucion + "\n\tCantidad de iteraciones " + this.i);


    }

    private void back(Solucion parcial) {
        this.i++;
        if (esEstadoFinal()) {
            if (esSolucion(parcial)) {
                operarSolucion(parcial);
            }
        } else if (this.solucion.getDiferenciaGrupos() != 0 ){


                Empleado e = this.candidatos.get(0);
                parcial.addIntegranteGrupo1(e);
                this.candidatos.remove(e);

                back(parcial);
                parcial.deleteIntegranteGrupo1(e);
                parcial.addIntegranteGrupo2(e);

                back(parcial);
                parcial.deleteIntegranteGrupo2(e);
                this.candidatos.add(0, e);

            }

    }


    public boolean esEstadoFinal() {

        if (this.candidatos.size() == 0)
            return true;
        else
            return false;

    }

    public boolean esSolucion(Solucion parcial) {
        if (parcial.getDiferenciaGrupos() < this.solucion.getDiferenciaGrupos() || this.solucion.getDiferenciaGrupos() == -1)
            return true;
        else
            return false;

    }

    public void operarSolucion(Solucion parcial) {

        this.solucion.setGrupo1(parcial.getCopiaGrupo1());
        this.solucion.setGrupo2(parcial.getCopiaGrupo2());
        this.solucion.setDiferenciaGrupos(parcial.getDiferenciaGrupos());

    }


}
