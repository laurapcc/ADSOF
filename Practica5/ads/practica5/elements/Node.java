package ads.practica5.elements;

import ads.practica5.graph.Graph;

import java.util.*;


/**
 * Clase Node
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Node<T> {

    private T value;
    private Graph<T, ?> graph;
    private int id;
    static private int nextval = 0;
    
    /**
     * Constructor de la clase Node
     * 
     * @param value valor del nodo
     */
    public Node(T value) {
        this.value = value;
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
     * Establece el valor que contiene el nodo
     * 
     * @param value valor del nodo
     */
	public void setValue(T value) {
		this.value = value;
	}

    /**
     * Devuelve el valor del nodo
     * 
     * @return : value de tipo T
     */
    public T getValue() {
        return value;
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
        return graph.isConnectedTo(this, node);
    }

    /**
     * Comprueba si el nodo actual esta conectado al nodo cuyo valor es 
     * pasada como argumento
     * 
     * @param value valor del nodo detino
     * @return true si el nodo actual esta conectado al que contiene el valor,
     * false en caso contrario
     */
    public boolean isConnectedTo(T value) {
        return graph.isConnectedTo(this, value);
    }

    /**
     * Devuelve una lista de todos los nodos con los que está conectado
     * 
     * @return : Collection conteniendo con los nodos vecinos
     */
    public Collection<Node<T>> neighbours() {
        return graph.neighbours(this);
    }

    /**
     * Crea una lista con los valores de las conexiones que tiene el nodo actual
     * sin incluir repetidos
     * 
     * @param dest nodo destino
     * @return lista de valores de los enlaces
     */
    public List<?> getEdgeValues(Node<T> dest) {
        return graph.getEdgeValues(this, dest);
    }

    /**
     * Override del método generico toString
     * 
     * @return : String
     */
    public String toString() {
        return id + " [" + value + "]";
    }
}
