package ads.practica5.rules;

import java.util.*;

import ads.practica5.strategies.Strategy;

/**
 * Clase RuleSetWithStrategy
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class RuleSetWithStrategy<T> {

    private List<Rule<T>> rules = new ArrayList<>();
    private Collection<T> context;
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
     * Anade una regla al conjunto de reglas con estrategia
     * 
     * @param rule regla
     * @return conjunto de reglas con estrategia actualizado
     */
    public RuleSetWithStrategy<T> add(Rule<T> rule) {
        rules.add(rule);
        return this;
    }

    /**
     * Establece el contexto (coleccion) sobre el que ejecutar el conjunto de reglas
     * con estrategia
     * 
     * @param context contexto
     */
    public void setExecContext(Collection<T> context) {
        this.context = context;
    }

    /**
     * Procesa la estrategia del conjunto de reglas sobre el contexto establecido
     */
    public void process() {
        strategy.process(rules, context);
    }
}