package ads.practica5.rules;

import java.util.*;

/**
 * Clase RuleSet
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class RuleSet<T> {

    private List<Rule<T>> rules = new ArrayList<>();
    private Collection<T> context;

    /**
     * Anade una regla al conjunto de reglas
     * 
     * @param rule regla
     * @return conjunto de reglas actualizado
     */
    public RuleSet<T> add(Rule<T> rule){
        rules.add(rule);
        return this;
    }

    /**
     * Establece el contexto (coleccion) sobre el que ejecutar el conjunto de reglas
     * 
     * @param context contexto
     */
    public void setExecContext(Collection<T> context){
        this.context = context;
    }

    /**
     * Procesa el conjunto de reglas sobre el contexto establecido
     */
    public void process(){
        for (T elem: context){
            for (Rule<T> rule: rules){
                if (rule.getPredicate().test(elem))
                    rule.getConsumer().accept(elem);
            }
        }
    }

}