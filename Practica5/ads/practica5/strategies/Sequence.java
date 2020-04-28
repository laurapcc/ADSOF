package ads.practica5.strategies;

import java.util.*;

import ads.practica5.rules.Rule;

/**
 * Clase Sequence
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 * 
 * @param <T> objeto parametrizado
 *
 */
public class Sequence<T> implements Strategy<T> {

    /**
     * Procesa la estrategia de aplicar, en secuencia, una regla tras otra sobre
     * el contexto establecido
     * 
     * @param rules conjunto de reglas que se aplica
     * @param context contexto sobre el que se aplica el conjunto de reglas
     */
    @Override
    public void process(List<Rule<T>> rules, Collection<T> context) {
        for (T elem : context) {
            for (Rule<T> rule : rules) {
                if (rule.getPredicate().test(elem))
                    rule.getConsumer().accept(elem);
            }
        }
    }

}