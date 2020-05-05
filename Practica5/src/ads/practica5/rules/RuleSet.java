package ads.practica5.rules;

import java.util.*;

/**
 * Clase RuleSet
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 * 
 * @param <T> objeto parametrizado
 */
public class RuleSet<T> {

    private List<Rule<T>> rules = new ArrayList<>();
    private Collection<T> context;

    /**
     * Devuelve el conjunto de reglas añadidas
     * 
     * @return lista con las reglas previamente añadidas
     */
    public List<Rule<T>> getRules(){
        return this.rules;
    }

    /**
     * Devuelve el contexo del conjunto de reglas     
     * 
     * @return contexto del RuleSet
     */
    public Collection<T> getContext(){
        return this.context;
    }

    /**
     * Anade una regla al conjunto de reglas
     * 
     * @param rule regla
     * @return conjunto de reglas actualizado
     */
    public RuleSet<T> add(Rule<T> rule) {
        rules.add(rule);
        return this;
    }

    /**
     * Establece el contexto (coleccion) sobre el que ejecutar el conjunto de reglas
     * 
     * @param context contexto
     */
    public void setExecContext(Collection<T> context) {
        this.context = context;
    }

    /**
     * Procesa el conjunto de reglas sobre el contexto establecido
     */
    public void process() {
        context.stream().forEach(c -> rules.stream()
                                            .filter(r -> r.getPredicate().test(c))
                                            .forEach(r -> r.getConsumer().accept(c)));
    }

}