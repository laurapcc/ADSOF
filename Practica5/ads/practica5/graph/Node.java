package ads.practica5.graph;

import java.util.*;

/**
 * Clase Node
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Node<T> {

    private T info;
    private Graph<T, ?> graph;
    private int id;
    static private int nextval = 0;
    
    /**
     * Constructor de la clase Node
     * 
     * @param info informacion del nodo
     */
    public Node(T info){
        this.info = info;
        id = nextval;
        nextval++;
    }

    /**
     * Establece el grafo al que pertenece el nodo
     * 
     * @param graph : Graph
     */
    public void setGraph(Graph<T, ?> graph) {
        this.graph = graph;
    }

    /**
     * Devuelve la información que contiene el nodo
     * 
     * @return : informacion de tipo T
     */
    public T getInfo() {
        return info;
    }

    /**
     * Devuelve el id del nodo
     * 
     * @return : id del nodo
     */
    public int getId() {
        return id;
    }

    /**
     * Comprueba si el nodo actual esta conectado al nodo cuya pasado como
     * argumento
     * 
     * @param node nodo destino
     * @return true si el nodo actual esta conectado al que se pasa como
     * argumento, false en caso contrario
     */
    public boolean isConnectedTo(Node<T> node) {
        for (Edge<?> edge : graph.getEdges()) {
            if (equals(edge.getOrigin())) {
                if (node.equals(edge.getDest()))
                    return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el nodo actual esta conectado al nodo cuya informacion es 
     * pasada como argumento
     * 
     * @param info informacion del nodo destino
     * @return true si el nodo actual esta conectado al que contiene info,
     * false en caso contrario
     */
    public boolean isConnectedTo(T info) {
        for (Edge<?> edge : graph.getEdges()) {
            if (equals(edge.getOrigin())) {
                if (info.equals(edge.getDest().getInfo()))
                    return true;
            }
        }
        return false;
    }

    /**
     * Devuelve una lista de todos los nodos con los que está conectado
     * 
     * @return : Collection conteniendo con los nodos vecinos
     */
    public Collection<Node<T>> neighbours() {
        Collection<Node<T>> neighbours = new ArrayList<>();
        for (Node<T> node : graph.getNodes()) {
            if (isConnectedTo(node))
                neighbours.add(node);
        }
        return neighbours;
    }

    /**
     * Crea una coleccion con los valores de las conexiones que tiene el nodo actual
     * 
     * @return coleccion de valores de los enlaces
     */
    public <V> Collection<? super V> getEdgeValues(Node<T> dest) {
        Collection<? super V> infoEdges = new ArrayList<>();
        for (Edge<?> edge : graph.getEdges()) {
            if (equals(edge.getOrigin()) && dest.equals(edge.getDest()))
                infoEdges.add((V)edge.getInfo());
        }
        return infoEdges;
    }

    /**
     * Override del método generico toString
     * 
     * @return : String
     */
    public String toString() {
        return id + " [" + info + "]";
    }
}
