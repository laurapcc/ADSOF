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
 * @param <T> tipo de dato generico que representa el valor del
 * nodo
 * @param <S> tipo de dato generico que representa el valor del
 * enlace
 *
 */
public class BlackBoxComparator<T, S> implements Comparator<ConstrainedGraph<T,S>> {
    private Map<Criteria, Set<Predicate<Node<T>>>> criteria = new HashMap<>();

    /**
     * Añade un criterio de comparacion al comparador de grafos
     * 
     * @param c criterio que rige al predicado de la comparacion
     * @param p predicado que será utilizado por la función comparador
     * @return mismo comparador con criterio añadido
     */
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

    /**
     * Compara dos grafos en base a los criterios que posee el propio
     * comparador
     * 
     * @param o1 primer grafo sobre el que se realizará la comparación
     * @param o2 segundo grafo sobre el que se realizará la comparación
     * @return entero positvo si o1 es mayor que o2, negativo si o1 es menor
     * y 0 si son iguales
     */
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