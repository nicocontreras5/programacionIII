package entregable_4_5;

import java.util.ArrayList;

public class Solucion {
    private int diferenciaGrupos;
    private GrupoTrabajo grupo1;
    private  GrupoTrabajo grupo2;


    public Solucion() {
        this.diferenciaGrupos = -1;
        this.grupo1 = new GrupoTrabajo("grupo1");
        this.grupo2 = new GrupoTrabajo("grupo2");;
    }

    public void agregarEmmpleadoGrupoMenor(Empleado e){

       if (this.grupo1.getFuerzaDeTrabajo() > this.grupo2.getFuerzaDeTrabajo())
               this.grupo2.addIntegrante(e);
       else
           this.grupo1.addIntegrante(e);
       this.diferenciaGrupos = Math.abs( this.grupo1.getFuerzaDeTrabajo() - this.grupo2.getFuerzaDeTrabajo());
    }


    public int getFuerzaGrupo1(){
        return this.grupo1.getFuerzaDeTrabajo();
    }
    public int getFuerzaGrupo2(){
        return this.grupo2.getFuerzaDeTrabajo();
    }


    public void deleteIntegranteGrupo1(Empleado e){

        this.grupo1.deleteIntegrante(e);
        this.diferenciaGrupos = Math.abs( this.grupo1.getFuerzaDeTrabajo() - this.grupo2.getFuerzaDeTrabajo());
    }

    public void deleteIntegranteGrupo2(Empleado e){

        this.grupo2.deleteIntegrante(e);
        this.diferenciaGrupos = Math.abs( this.grupo1.getFuerzaDeTrabajo() - this.grupo2.getFuerzaDeTrabajo());
    }

    public void addIntegranteGrupo1( Empleado e){

        this.grupo1.addIntegrante(e);
        this.diferenciaGrupos = Math.abs( this.grupo1.getFuerzaDeTrabajo() - this.grupo2.getFuerzaDeTrabajo());

    }

    public void addIntegranteGrupo2( Empleado e){

        this.grupo2.addIntegrante(e);
        this.diferenciaGrupos = Math.abs( this.grupo1.getFuerzaDeTrabajo() - this.grupo2.getFuerzaDeTrabajo());

    }

    public void setGrupo2(GrupoTrabajo g){
        this.grupo2 = g;


    }

    public void setGrupo1(GrupoTrabajo g){
        this.grupo1 = g;

    }

    public GrupoTrabajo getCopiaGrupo1(){
        return this.grupo1.getCopiaGrupo();
    }

    public GrupoTrabajo getCopiaGrupo2(){
        return this.grupo2.getCopiaGrupo();
    }

    public int getDiferenciaGrupos(){
        return this.diferenciaGrupos;
    }

    public void setDiferenciaGrupos(int diferenciaGrupos) {
        this.diferenciaGrupos = diferenciaGrupos;
    }

    @Override
    public String toString() {
        return "\t" +this.grupo1 + "\n\t" + this.grupo2 + "\n\tdiferencia Grupos " + this.diferenciaGrupos;
    }
}
