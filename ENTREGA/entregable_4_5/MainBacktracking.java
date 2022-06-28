package entregable_4_5;

import java.util.ArrayList;

public class MainBacktracking {
    public static <T> void main(String[] args) {



        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        //creo empleados
        Empleado empleado1 = new Empleado("Juan", "Pérez", 32, 48);
        Empleado empleado2 = new Empleado("Roberto", "Hernández", 45, 57);
        Empleado empleado3 = new Empleado("Camila", "Gutiérrez", 33, 51);
        Empleado empleado4 = new Empleado("Francisco", "Martínez", 22, 73);
        Empleado empleado5 = new Empleado("Benjamín", "Núnez", 55, 15);
        Empleado empleado6 = new Empleado("Mateo", "Morales", 24, 33);
        Empleado empleado7 = new Empleado("Delfina", "López", 36, 92);
        Empleado empleado8 = new Empleado("Catalina", "Cruz", 51, 71);
        Empleado empleado9 = new Empleado("Benicio", "Montero", 48, 19);
        Empleado empleado10 = new Empleado("Valentino", "González", 58, 22);
        Empleado empleado11 = new Empleado("Olivia", "Gómez", 33, 41);
        Empleado empleado12 = new Empleado("Martina", "Díaz", 21, 49);
        Empleado empleado13 = new Empleado("Joaquín", "Cabrera", 22, 14);
        Empleado empleado14 = new Empleado("Bautista", "Domínguez", 36, 33);
        Empleado empleado15 = new Empleado("Emilia", "Paz", 40, 16);
        Empleado empleado16 = new Empleado("Francesca", "Figueroa", 43, 21);
        Empleado empleado17 = new Empleado("Santino", "Blanco", 25, 79);
        Empleado empleado18 = new Empleado("Ignacio", "Ibarra", 61, 32);
        Empleado empleado19 = new Empleado("Andrea", "Chávez", 27, 78);
        Empleado empleado20 = new Empleado("Elena", "Mengochea", 52, 67);


        Empresa empresita = new Empresa(empleados);

        // Entrada 1

        System.out.println("Entrada 1:");

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        empleados.add(empleado4);
        empleados.add(empleado5);
        empleados.add(empleado6);

        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 2

        System.out.println("Entrada 2:");


        empleados.add(empleado7);
        empleados.add(empleado4);
        empleados.add(empleado8);
        empleados.add(empleado15);

        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 3

        System.out.println("Entrada 3:");

        empleados.add(empleado19);
        empleados.add(empleado12);
        empleados.add(empleado11);
        empleados.add(empleado13);

        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 4

        System.out.println("Entrada 4:");

        empleados.add(empleado19);
        empleados.add(empleado18);
        empleados.add(empleado14);
        empleados.add(empleado16);

        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();
        // Entrada 5

        System.out.println("Entrada 5:");

        empleados.add(empleado7);
        empleados.add(empleado8);
        empleados.add(empleado20);
        empleados.add(empleado3);
        empleados.add(empleado16);



        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 6

        System.out.println("Entrada 6:");

        empleados.add(empleado6);
        empleados.add(empleado15);
        empleados.add(empleado17);
        empleados.add(empleado13);
        empleados.add(empleado16);
        empleados.add(empleado10);


        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 7

        System.out.println("Entrada 7:");

        empleados.add(empleado17);
        empleados.add(empleado2);
        empleados.add(empleado19);
        empleados.add(empleado20);
        empleados.add(empleado4);
        empleados.add(empleado12);
        empleados.add(empleado15);



        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 8

        System.out.println("Entrada 8:");

        empleados.add(empleado12);
        empleados.add(empleado14);
        empleados.add(empleado18);
        empleados.add(empleado6);
        empleados.add(empleado2);
        empleados.add(empleado9);
        empleados.add(empleado10);
        empleados.add(empleado16);


        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();

        // Entrada 9

        System.out.println("Entrada 9:");

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        empleados.add(empleado4);
        empleados.add(empleado5);
        empleados.add(empleado6);
        empleados.add(empleado7);
        empleados.add(empleado8);
        empleados.add(empleado9);
        empleados.add(empleado10);
        empleados.add(empleado11);
        empleados.add(empleado12);
        empleados.add(empleado13);
        empleados.add(empleado14);
        empleados.add(empleado15);
        empleados.add(empleado16);
        empleados.add(empleado17);
        empleados.add(empleado18);
        empleados.add(empleado19);
        empleados.add(empleado20);

        empresita.crearGruposDeTrabajoBack(empleados);
        empleados.clear();





    }
}
