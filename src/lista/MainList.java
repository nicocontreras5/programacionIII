package lista;

public class MainList {
    public static void main(String[] args) {

        MySimpleLinkedList list1= new MySimpleLinkedList();
        System.out.print("lista original ejemplo1 ");
        System.out.println(list1);
        System.out.print( " lista resultante ");
        Entregable eje1= new Entregable(list1,10);
        System.out.println( eje1.getSubsecuenciasList());
        System.out.println( " valor umbral " + 10);


        MySimpleLinkedList list2= new MySimpleLinkedList();
        System.out.print("lista original ejemplo2 ");
        list2.insertBack(1);
        list2.insertBack(2);
        list2.insertBack(3);
        System.out.println(list2);
        System.out.print( " lista resultante ");
        Entregable ej2= new Entregable(list2,10);
        System.out.println( ej2.getSubsecuenciasList());
        System.out.println( " valor umbral " + 10);


        System.out.print("lista original ejemplo3 ");
        System.out.println(list2);
        Entregable ej3= new Entregable(list2,2);
        System.out.print( " lista resultante ");
        System.out.println( ej3.getSubsecuenciasList());
        System.out.println( " valor umbral " + 2);


        MySimpleLinkedList list4= new MySimpleLinkedList();
        System.out.print("lista original ejemplo4 ");
        list4.insertBack(3);
        list4.insertBack(5);
        list4.insertBack(2);
        list4.insertBack(7);
        list4.insertBack(19);
        list4.insertBack(14);
        list4.insertBack(28);
        System.out.println(list4);
        Entregable ej4= new Entregable(list4,10);
        System.out.print( " lista resultante ");
        System.out.println(ej4.getSubsecuenciasList());
        System.out.println( " valor umbral " + 10);


        MySimpleLinkedList list5= new MySimpleLinkedList();
        System.out.print("lista original ejemplo5 ");
        list5.insertBack(3);
        list5.insertBack(5);
        list5.insertBack(4);
        list5.insertBack(2);
        list5.insertBack(7);
        list5.insertBack(15);
        list5.insertBack(14);
        list5.insertBack(28);
        System.out.println(list5);
        System.out.print( " lista resultante ");
        Entregable ej5= new Entregable(list5,15);
        System.out.println(ej5.getSubsecuenciasList());
        System.out.println( " valor umbral " + 15);





    }

}
