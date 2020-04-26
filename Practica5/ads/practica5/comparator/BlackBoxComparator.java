package ads.practica5.comparator;

import java.util.*;
import java.util.function.*;

import ads.practica5.elements.Node;
import ads.practica5.graph.*;

/**
 * Clase BlackBoxComparator
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class BlackBoxComparator<T, S> implements Comparator<ConstrainedGraph<T,S>> {
    private Map<Criteria, Set<Predicate<Node<T>>>> criteria = new HashMap<>();

    public BlackBoxComparator<T,S> addCriteria(Criteria c, Predicate<Node<T>> p) {
        if (criteria.containsKey(c)) {
            criteria.get(c).add(p);
        }
        else {
            Set<Predicate<Node<T>>> predicateSet = new HashSet<>();
            predicateSet.add(p);
            criteria.put(c, predicateSet);
        }
        return this;
    }

    @Override
    public int compare(ConstrainedGraph<T, S> o1, ConstrainedGraph<T, S> o2) {
        int o1cumple = 0;
        int o2cumple = 0;

        for (Criteria c : criteria.keySet()) {
            for (Predicate<Node<T>> p : criteria.get(c)) {
                if (c.test(o1, p))
                    o1cumple++;
                if (c.test(o2, p))
                    o2cumple++;
            }
        }

        return o1cumple-o2cumple;
    }
}