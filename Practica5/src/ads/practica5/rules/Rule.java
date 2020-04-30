package ads.practica5.rules;

import java.util.function.*;

/**
 * Clase Rule
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 * 
 * @param <T> objeto parametrizado
 */
public class Rule<T> implements IRule<T> {

    private String name;
    private String desc;
    private Predicate<T> predicate;
    private Consumer<T> consumer;

    /**
     * Constructor privado de la clase Rule
     * 
     * @param name nombre de la regla
     * @param desc descripcion de la regla
     */
    private Rule(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    /**
     * Crea una regla sobre el tipo de dato parametrizado
     * 
     * @param <T> dato parametrizado
     * @param name nombre de la regla
     * @param desc descripcion de la regla
     * @return nueva regla creada
     */
    public static <T> Rule<T> rule(String name, String desc) {
        return new Rule<T>(name, desc);
    }

    /**
     * Devuelve el nombre de la regla
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve la descripcion de la regla
     * 
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Devuelve el predicado asociado a la regla
     * 
     * @return predicado
     */
    public Predicate<T> getPredicate() {
        return predicate;
    }

    /**
     * Devuelve el consumible asociado a la regla
     * 
     * @return consumible
     */
    public Consumer<T> getConsumer() {
        return consumer;
    }

    /**
     * Establece como predicado de la regla cuando se puede ejecutar
     * 
     * @param p predicado
     * @return regla con el predicado actualizado
     */
    @Override
    public Rule<T> when(Predicate<T> p) {
        this.predicate = p;
        return this;
    }

    /**
     * Establece como consumible de la regla la accion a ejecutar
     * 
     * @param c consumible
     * @return regla con el consumible actualizado
     */
    @Override
    public Rule<T> exec(Consumer<T> c) {
        this.consumer = c;
        return this;
    }
}