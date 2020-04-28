package ads.practica5.strategies;

import java.util.*;

import ads.practica5.rules.Rule;

/**
 * Interface Strategy
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 * 
 * @param <T> objeto parametrizado
 *
 */
public interface Strategy<T> {

    /**
     * Procesa la estrategia del conjunto de reglas sobre el contexto establecido
     * 
     * @param rules conjunto de reglas que se aplica
     * @param context contexto sobre el que se aplica el conjunto de reglas
     */
    public void process(List<Rule<T>> rules, Collection<T> context);
}