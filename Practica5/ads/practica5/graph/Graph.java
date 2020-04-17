package ads.practica5.graph;

import java.util.*;

/**
 * Clase Graph
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Graph<T, S> implements Collection {

    Set<Node<T>> nodos = new HashSet<Node<T>>(); // no se si HashSet u otro tipo
    // Array de edges?

    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    public void connect(Node<T> n1, S e, Node<T> n2){

    }

    // iterator para el for mejorado

    // convertir a lista para poder pasarselo al constructor de arraylist
    
    
}