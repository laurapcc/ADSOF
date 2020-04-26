package ads.practica5.comparator;

import ads.practica5.elements.Node;
import ads.practica5.graph.ConstrainedGraph;

import java.util.function.Predicate;

/**
 * Enumeracion Criteria
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public enum Criteria {
    EXISTENTIAL, UNITARY, UNIVERSAL;

    public <T,S> boolean test(ConstrainedGraph<T, S> o, Predicate<Node<T>> p) {
        if (equals(EXISTENTIAL))
            return o.exists(p);
        else if (equals(UNITARY))
            return o.one(p);
        else
            return o.forAll(p);
    }
}