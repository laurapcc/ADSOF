package ads.practica5.graph;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

import ads.practica5.elements.*;

/**
 * Clase ConstrainedGraph
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class ConstrainedGraph<T, S> extends Graph<T, S> {

    Optional<Node<T>> witness;

    /**
     * Devuelve el nodo testigo como un objeto opcional
     * 
     * @return : testigo opcional
     */
    public Optional<Node<T>> getWitness(){
        return witness;
    }
    
    /**
     * Comprueba si todos los nodos del grafo cumplen un predicado
     * 
     * @param p predicado
     * @return true si todos los nodos cumplen el predicado
     */
    public boolean forAll(Predicate<Node<T>> p){
        return getNodes().stream().allMatch(p);
    }

    /**
     * Comprueba si los nodos del grafo cumplen un predicado
     * 
     * @param p predicado
     * @return true si solo un nodo cumple el predicado
     */
    public boolean one(Predicate<Node<T>> p){
        List<Node<T>> cumplen = getNodes().stream().filter(p).collect(Collectors.toList());
        return cumplen.size() == 1;
    }

    /**
     * Comprueba si los nodos del grafo cumplen un predicado
     * 
     * @param p predicado
     * @return true si al menos un nodo cumple el predicado
     */
    public boolean exists(Predicate<Node<T>> p){
        witness = getNodes().stream().filter(p).findFirst();
        return witness.isPresent();
    }
}