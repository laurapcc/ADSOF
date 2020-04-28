package ads.practica5.graph;

import ads.practica5.elements.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase Graph
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Graph<T, S> implements Collection<Node<T>> {

    Set<Node<T>> nodes = new HashSet<>();
    List<Edge<S>> edges = new ArrayList<>();
    
    /**
     * Devuelve la lista de enlaces pertenecientes al grafo
     * 
     * @return : Lista de edges del grafo
     */
    public List<Edge<S>> getEdges() {
        return edges;
    }

    /**
     * Devuelve el conjunto de nodos pertenecientes al grafo
     * 
     * @return : Conjunto de nodos del grafo
     */
    public Set<Node<T>> getNodes() {
        return nodes;
    }

    /**
     * Crea una conexion entre el nodo n1 como origen y el nodo n2 como destino,
     * con la informacion del enlace pasada como argumento
     * 
     * @param n1 nodo origen
     * @param e informacion del enlace
     * @param n2 nodo destino
     */
    public void connect(Node<T> n1, S e, Node<T> n2) {
        if (!contains(n1) || !contains(n2))
            return;
        Edge<S> edge = new Edge<>(n1, e, n2);
        edges.add(edge);
    }

    /**
     * Comprueba si el nodo pasado como primer arguento esta conectado 
     * al nodo cuya pasado como segundo argumento
     * 
     * @param n1 nodo origen
     * @param n2 nodo destino
     * @return true si el nodo n1 esta conectado al nodo n2, false en
     * caso contrario
     */
    public boolean isConnectedTo(Node<T> n1, Node<T> n2) {
        for (Edge<S> edge : edges) {
            if (n1.equals(edge.getOrigin())) {
                if (n2.equals(edge.getDest()))
                    return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el nodo pasado como primer arguento esta conectado 
     * al nodo cuyo valor es pasada como segundo argumento
     * 
     * @param node nodo origen
     * @param value valor del nodo destino
     * @return true si el nodo pasado como primer argumento esta conectado
     * al que contiene el valor, false en caso contrario
     */
    public boolean isConnectedTo(Node<T> node, T value) {
        for (Edge<S> edge : edges) {
            if (node.equals(edge.getOrigin())) {
                if (value.equals(edge.getDest().getValue()))
                    return true;
            }
        }
        return false;
    }

    /**
     * Devuelve una lista de todos los nodos con los que está conectado el nodo
     * pasado como argumento
     * 
     * @param node nodo del cual queremos ver sus vecinos
     * @return : Collection conteniendo los nodos vecinos
     */
    public Collection<Node<T>> neighbours(Node<T> node) {
        Collection<Node<T>> neighbours = new ArrayList<>();
        for (Node<T> n : nodes) {
            if (isConnectedTo(node, n))
                neighbours.add(n);
        }
        return neighbours;
    }

    /**
     * Crea una lista con los valores de las conexiones que tiene el primer nodo
     * pasado como argumento con el segundo nodo pasado como argumento
     * 
     * @param n1 nodo origen
     * @param n2 nodo destino
     * @return lista de valores de los enlaces (sin repetidos)
     */
    public List<S> getEdgeValues(Node<T> n1, Node<T> n2) {
        Set<S> valueEdges = new HashSet<>();

        for (Edge<S> edge : edges) {
            if (n1.equals(edge.getOrigin()) && n2.equals(edge.getDest())) {
                valueEdges.add(edge.getValue());
            }
        }

        return valueEdges.stream().collect(Collectors.toList());
    }

    /**
     * Anade un nodo a la coleccion de nodos del grafo
     * 
     * @param arg0 nodo a anadir
     * @return true si se ha anadido correctamente, false si el nodo ya existia en el grafo
     */
    @Override
    public boolean add(Node<T> arg0) {
        arg0.setGraph(this);
        return nodes.add(arg0);
    }

    /**
     * Anade al grado todos los nodos de la coleccion pasada como argumento
     * 
     * @param arg0 coleccion de nodos a anadir al grafo
     * @return true si se han anadido correctamente todos los nodos,
     * false si el nodo ya existia en el grafo
     */
    @Override
    public boolean addAll(Collection<? extends Node<T>> arg0) {
        boolean retval = false;
        for (Node<T> node : arg0){
            if (add(node))
                retval = true;
        }
        return retval;
    }

    /**
     * Vacia el grafo, es decir, elimina todos sus nodos y las conexiones entre ellos
     */
    @Override
    public void clear() {
        nodes.clear();
        edges.clear();
    }

    /**
     * Comprueba si el grafo contiene el nodo pasado como argumento
     * 
     * @param arg0 nodo
     * @return true si el grado contine al nodo, false en caso contrario
     */
    @Override
    public boolean contains(Object arg0) {
        return nodes.contains(arg0);
    }

    /**
     * Comprueba si el grafo contiene los nodos pasados como argumento
     * 
     * @param arg0 coleccion de nodos
     * @return true si todos los nodos de la coleccion pertenecen al grafo,
     * false en caso contrario
     */
    @Override
    public boolean containsAll(Collection<?> arg0) {
        return nodes.containsAll(arg0);
    }

    /**
     * Comprueba si el grafo esta vacio, es decir, si no contiene nigun nodo
     * 
     * @return true si el grafo esta vacio, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    /**
     * Devuelve el iterador sobre los nodos del grafo
     * 
     * @return iterador sobre los nodos
     */
    @Override
    public Iterator<Node<T>> iterator() {
        return nodes.iterator();
    }

    /**
     * Elimina un nodo del grafo, asi como todas sus conexiones
     * 
     * @param arg0 nodo a eliminar
     * @return true si se ha modificado la coleccion de nodos, false en caso contrario
     */
    @Override
    public boolean remove(Object arg0) {
        for (Iterator<Edge<S>> itr = edges.iterator(); itr.hasNext(); ) {
            if (itr.next().getOrigin().equals(arg0) || itr.next().getDest().equals(arg0))
                itr.remove();
        }
        return nodes.remove(arg0);
    }

    /**
     * Elimina todos los nodos de la coleccion pasada como argumento que pertenezcan al grafo
     * 
     * @param arg0 coleccion con nodos a eliminar
     * @return true si se ha modificado la coleccion de nodos, false en caso contrario
     */
    @Override
    public boolean removeAll(Collection<?> arg0) {
        boolean retval = false;
        for (Object o : arg0) {
            if (remove(o))
                retval = true;
        }
        return retval;
    }

    /**
     * Elimina de la coleccion de nodos todos aquellos que no pertenezcan a la coleccion
     * pasada como argumento
     * 
     * @param arg0 coleccion con nodos a mantener en el grafo
     * @return true si se ha modificado la coleccion de nodos, false en caso contrario
     */
    @Override
    public boolean retainAll(Collection<?> arg0) {
        Collection<Node<T>> col = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (arg0.contains(node))
                continue;
            col.add(node);
        }
        return removeAll(col);
    }

    /**
     * Devuelve el numero de nodos que contiene el grafo
     * 
     * @return numero de nodos
     */
    @Override
    public int size() {
        return nodes.size();
    }

    /**
     * Transforma la coleccion de nodos a un array de objetos
     * 
     * @return array de objetos
     */
    @Override
    public Object[] toArray() {
        return nodes.toArray();
    }

    /**
     * Transforma la coleccion de nodos a un array de objetos del tipo del array que se
     * pasa como argumento
     * 
     * @param arg0 array de tipo generico V
     * @return array de tipo V que contiene todos los nodos del grado
     */
    @Override
    public <V> V[] toArray(V[] arg0) {
        return nodes.toArray(arg0);
    }   

    /**
     * Override del método generico toString
     * 
     * @return : String
     */
    @Override
    public String toString(){
        String ret = "Nodes:\n";
        for (Node<T> n: nodes)
            ret += " " + n.toString() + "\n";

        ret += "Edges:\n";
        for (Edge<S> e: edges)
            ret += " " + e.toString() + "\n";

        return ret;
    }
}