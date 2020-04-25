package ads.practica5.comparator;

import java.util.Comparator;
import java.util.function.Predicate;

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

    BlackBoxComparator<T,S> addCriteria(Criteria c, Predicate<Node<T>> p){
        // TODO
        return null;
    }

    @Override
    public int compare(ConstrainedGraph<T, S> o1, ConstrainedGraph<T, S> o2) {
        // TODO Auto-generated method stub
        return 0;
    }


    
}