package entregable_4_5;

public class Empleado {
    private String  nombre;
    private String apellido;
    private int edad;
    private int fuerzaTrabajo;


    public Empleado(String nombre, String apellido, int edad, int fuerzaTrabajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fuerzaTrabajo = fuerzaTrabajo;
    }




    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getFuerzaDeTrabajo() {
       return this.fuerzaTrabajo;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
