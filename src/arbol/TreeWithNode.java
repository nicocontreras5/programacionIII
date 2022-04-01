package arbol;

import java.util.ArrayList;

public class TreeWithNode {

    private TreeNode raiz;

    // hacer
    // Complejidad: big O O(h *N)  h = h es la altura del arbol y n = a la cantidad de elementos del array que vana  ser insertados en el arbol
    public TreeWithNode( int[]  array) {
        this.raiz = null;
        for (int i: array) {
            this.add(i);
        }
    }

    // Complejidad: big O O(h)  h = a la altura del arbol(en el peor de los casos  itero tantas veces como la altura del arbol)

    public void add(int value) {
        if (this.raiz == null)
            this.raiz = new TreeNode(value);
        else
            this.add(this.raiz, value);
    }

    // Complejidad: big O O(h)  h=  a la altura del arbol(en el peor de los casos  itero tantas veces como la altura del arbol)
    private void add(TreeNode node, int value) {
        if (value < node.getValue()) {
            if (node.getIzq() == null) {
                TreeNode temp = new TreeNode(value);
                node.setIzq(temp);
            } else {
                add(node.getIzq(), value);
            }
        } else {
            if (node.getDer() == null) {
                TreeNode temp = new TreeNode(value);

                node.setDer(temp);
            } else {
                add(node.getDer(), value);
            }
        }
    }



    // Complejidad: big O O(n)  n=  es la cantidad de nodos del arbol. (en el peor de los casos el nodo q buscamos par aborrar es el ultimo del arbol)
    public boolean delete(int value) {
        if (this.isEmpty())
            return false;
        else
            return delete(this.raiz, null, value);

    }
    // Complejidad: big O O(h)  h=  es la altura del arbol. (en el peor de los casos el nodo q buscamos es frontera de la rama mas alta del arbol y el algoritmo al ir dividiendo por ramas pasa por la mitad del arbol y justo esa mitad es la rama mas larga)
    private boolean delete(TreeNode node, TreeNode parentNode, int value){
        boolean borro = false;
        if (node != null){
            if (node.getValue() == value){
                // el nodo es una hoja
                if ((node.getIzq()== null) && (node.getDer() == null)){
                    if (parentNode != null){
                        if (parentNode.getDer() != null)
                            parentNode.setDer(null);
                        else
                            parentNode.setIzq(null);
                    }else{
                        this.raiz = null;
                    }

                }
                //el nodo tiene una rama hija
                else if ((node.getIzq() == null) ||(node.getDer()== null)){
                    if (parentNode != null){
                        if (node.getValue() > parentNode.getValue())
                            if (node.getDer() != null)
                                parentNode.setDer(node.getDer());
                            else
                                parentNode.setDer(node.getIzq());
                        else if (node.getDer() != null)
                            parentNode.setIzq(node.getDer());
                            else
                            parentNode.setIzq(node.getIzq());
                    }else{
                        if (node.getDer() != null)
                            this.raiz = node.getDer();
                        else
                            this.raiz = node.getIzq();
                    }


                }
                //el nodo tiene 2 ramas hijas
                else{
                    TreeNode NMI = NMI(node.getDer());
                    delete(NMI.getValue());
                    NMI.setIzq(node.getIzq());
                    NMI.setDer(node.getDer());

                    if (parentNode != null){
                        if (parentNode.getIzq()== node)
                            parentNode.setIzq(NMI);
                        else
                            parentNode.setDer(NMI);
                    }
                    else
                        this.raiz = NMI;
                }

                borro = true;
            }

            else if ( node.getValue() > value)
                borro = delete(node.getIzq(), node, value);
            else
                borro = delete(node.getDer(),node,  value);
        }



        return borro;
    }

    // Complejidad: big O O(h) h es la altura del arbol. (en el peor de los casos buscamos el nmi en la rama mas larga del arbol)
    private TreeNode NMI( TreeNode node){
        if (node.getIzq() != null)
            return NMI(node.getIzq());
        else
            return node;
    }


    // Complejidad: O(n) n = cantidad de nodos del árbol  ( siempre recorre todos los nodos por que no va dividiendo el arbol en dos. y en el peor d elos casos pido los nodos del ultimo nivel equivalente a pedir las fronteras)
    public ArrayList<Integer> getElemAtLevel(int level) {
        if ( ! isEmpty())
            if (level > 0)
                return getElemAtLevel(level, 0, this.raiz);

        return new ArrayList<Integer>();
    }

    // Complejidad: O(n) n = cantidad de nodos del árbol  ( siempre recorre todos los nodos por que no va dividiendo el arbol en dos. y en el peor d elos casos pido los nodos del ultimo nivel equivalente a pedir las fronteras)
    private ArrayList<Integer> getElemAtLevel(int level, int contador, TreeNode node) {

        ArrayList<Integer> list = new ArrayList<>();

        if (node != null) {

            if (contador <= level) {
                list.addAll(getElemAtLevel(level, contador + 1, node.getIzq()));
                list.addAll(getElemAtLevel(level, contador + 1, node.getDer()));
            }

            if (contador == level) {
                list.add(node.getValue());
            }
        }
        return list;
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos bsucando al rama mas larga)
    public ArrayList<Integer> getLongestBranch() {
        if ( ! isEmpty()) {
            return getLongestBranch(this.raiz);
        } else {
            return new ArrayList<Integer>();
        }
    }

    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos bsucando al rama mas larga)
    private ArrayList<Integer> getLongestBranch(TreeNode node) {

        ArrayList<Integer> izq = new ArrayList<>();
        ArrayList<Integer> der = new ArrayList<>();

        izq.add(node.getValue());
        der.add(node.getValue());

        if (node.getIzq() != null)
            izq.addAll(getLongestBranch(node.getIzq()));

        if (node.getDer() != null)
            der.addAll(getLongestBranch(node.getDer()));

        if (izq.size() < der.size())
            return der;
        else
            return izq;
    }


    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    public int getHeight() {
        if ( ! isEmpty())
            return getHeight(this.raiz);
        else
            return 0;
    }

    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    private int getHeight(TreeNode node) {

        int valorIzq = 0;
        int valorDer = 0;

        if (node.getIzq() != null)
            valorIzq = getHeight(node.getIzq()) + 1;

        if (node.getDer() != null)
            valorDer = getHeight(node.getDer()) + 1;

        return Math.max(valorIzq, valorDer);

    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    public ArrayList<Integer> getFrontera() {
        if ( ! isEmpty())
            return getFrontera(this.raiz);
        else
            return new ArrayList<Integer>();
    }

    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    private ArrayList<Integer> getFrontera(TreeNode node) {

        ArrayList<Integer> list = new ArrayList<>();

        if (node != null) {
            if (node.getIzq() == null && node.getDer() == null) {
                list.add(node.getValue());
            }
            list.addAll(getFrontera(node.getIzq()));
            list.addAll(getFrontera(node.getDer()));
        }
        return list;
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    public void preOrden() {
        preOrden(this.raiz);
    }

    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    private void preOrden(TreeNode node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrden(node.getIzq());
            preOrden(node.getDer());
        } else {
            System.out.println("-");
        }
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    public void postOrder() {
        postOrder(this.raiz);
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    private void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getIzq());
            postOrder(node.getDer());
            System.out.println(node.getValue());
        } else {
            System.out.println("-");
        }
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    public void inOrder() {
        inOrder(this.raiz);
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getIzq());
            System.out.println(node.getValue());
            inOrder(node.getDer());
        } else {
            System.out.println("-");
        }
    }

    // Complejidad: O(1)
    public Integer getRoot() {
        if (this.raiz != null)
            return this.raiz.getValue();
        return null;
    }

    // Complejidad: O(1)
    public boolean isEmpty() {
        return this.raiz == null;
    }
    // Complejidad: O(n) n = Cantidad de nodos (en el peor caso paso por todos los nodos)
    public boolean hasElem(int value) {
        if (this.raiz == null)
            return false;
        else
            return hasElem(value, this.raiz);
    }

    // Complejidad: O(h) h = es la altura del arbol (en el peor caso pido el nodo hubicado en la rama mas larga del arbol)
    private boolean hasElem(int value, TreeNode node) {
        if (node != null) {
            if (value > node.getValue())
                return hasElem(value, node.getDer());
            else if (value < node.getValue())
                return hasElem(value, node.getIzq());
            else
                return true;
        }
        return false;
    }


    // Complejidad: O(h) h = Altura del árbol (en el peor caso voy a iterar hasta  la altura del árbol)
    public Integer getMaxElem() {
        if ( ! isEmpty()) {
            TreeNode node = toDer(this.raiz);
            return node.getValue();
        }
        return null;
    }

    // Complejidad: O(h) h = Altura del árbol (en el peor caso voy a iterar hasta  la altura del árbol)
    private TreeNode toDer(TreeNode node) {
        if (node.getDer() != null)
            return toDer(node.getDer());
        return node;
    }

    // Complejidad: O(h) h = Altura del árbol (en el peor caso voy a iterar hasta  la altura del árbol)
    public Integer getMinElem() {
        if ( ! isEmpty()) {
            TreeNode node = toIzq(this.raiz);
            return node.getValue();
        }
        return null;
    }

    // bigO O(h) h = Altura del árbol (en el peor caso voy a iterar hasta  la altura del árbol)
    private TreeNode toIzq(TreeNode node) {
        if (node.getIzq() != null)
            return toIzq(node.getIzq());
        return node;
    }
}
