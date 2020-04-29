package ads.practica5.comparator;

import ads.practica5.elements.Node;
import ads.practica5.graph.ConstrainedGraph;

import java.util.function.Predicate;

/**
 * Enumeracion Criteria
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 */
public enum Criteria {
    EXISTENTIAL, UNITARY, UNIVERSAL;

    /**
     * Realiza un test sobre el grafo o en función del criterio y el predicado p
     * 
     * @param <T> tipo de dato genérico referenciando el tipo de nodos del grafo
     * @param <S> tipo de dato genérico referenciando el tipo de edges del grafo
     * @param o grafo sobre el que se realiza el test
     * @param p predicado que utilizará el test
     * @return true si el grafo ha pasado el test, false en caso contrario
     */
    public <T,S> boolean test(ConstrainedGraph<T, S> o, Predicate<Node<T>> p) {
        if (equals(EXISTENTIAL))
            return o.exists(p);
        else if (equals(UNITARY))
            return o.one(p);
        else
            return o.forAll(p);
    }
}