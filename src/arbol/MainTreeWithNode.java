package arbol;

public class MainTreeWithNode {

    public static void main(String[] args) {


        int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};

        TreeWithNode tree = new TreeWithNode(valoresIniciales);

        tree.preOrden();
        System.out.println("getMaxElem: " + tree.getMaxElem());
        System.out.println("getHeight: " + tree.getHeight());
        System.out.println("getLongestBranch: " + tree.getLongestBranch());
        System.out.println("getElemAtLevel: " + tree.getElemAtLevel(2));
        System.out.println("getFrontera: " + tree.getFrontera());

        tree.add(23);
        tree.add(3);
        tree.delete(6);
        tree.delete(30);

        tree.preOrden();
        System.out.println("getMaxElem: " + tree.getMaxElem());
        System.out.println("getHeight: " + tree.getHeight());
        System.out.println("getLongestBranch: " + tree.getLongestBranch());
        System.out.println("getElemAtLevel: " + tree.getElemAtLevel(2));
        System.out.println("getFrontera: " + tree.getFrontera());

        tree.add(65);
        tree.delete(5);
        tree.delete(15 );
        tree.add(55);

        tree.preOrden();
        System.out.println("getMaxElem: " + tree.getMaxElem());
        System.out.println("getHeight: " + tree.getHeight());
        System.out.println("getLongestBranch: " + tree.getLongestBranch());
        System.out.println("getElemAtLevel: " + tree.getElemAtLevel(2));
        System.out.println("getFrontera: " + tree.getFrontera());

    }
}
