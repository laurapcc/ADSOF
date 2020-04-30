package ads.practica5.rules;

import ads.practica5.strategies.Strategy;

/**
 * Clase RuleSetWithStrategy
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 * 
 * @param <T> objeto parametrizado
 */
public class RuleSetWithStrategy<T> extends RuleSet<T>{

    private Strategy<T> strategy;

    /**
     * Constructor de la clase RuleSetWithStrategy
     * 
     * @param strategy estrategia que se va a seguir al aplicar
     * el conjunto de reglas
     */
    public RuleSetWithStrategy(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    /**
     * Procesa la estrategia del conjunto de reglas sobre el contexto establecido
     */
    @Override
    public void process() {
        strategy.process(getRules(), getContext());
    }
}