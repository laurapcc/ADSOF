package ads.practica5.rules;

import java.util.function.Consumer;
import java.util.function.Predicate;

import ads.practica5.observers.Observer;
import ads.practica5.observers.Observable;

/**
 * Clase TriggeredRule
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 * @param <T> objeto parametrizado
 */
public class TriggeredRule<T extends Observable> implements IRule<T>, Observer {

    private String name;
    private Predicate<T> predicate;
    private Consumer<T> consumer;
    private T elem;

    /**
     * Constructor privado de la clase Rule
     * 
     * @param name nombre de la regla
     */
    private TriggeredRule(String name) {
        this.name = name;
    }
    
    /**
     * Crea una regla sobre el tipo de dato parametrizado
     * 
     * @param <T> dato parametrizado
     * @param name nombre de la regla
     * @return nueva regla creada
     */
    public static <T extends Observable> TriggeredRule<T> trigRule(String name) {
        return new TriggeredRule<T>(name);
    }

    /**
     * Añade un trigger al TriggeredRule
     * 
     * @param elem  elemento sobre el que se realizara el trigger
     * @param field nombre del atributo del elemento sobre el que se realizara el
     *              trigger
     * @return regla con el trigger actualizado
     */
    public TriggeredRule<T> trigger(T elem, String field) {
        this.elem = elem;
        elem.attach(this, field);
        return this;
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
    public TriggeredRule<T> when(Predicate<T> p) {
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
    public TriggeredRule<T> exec(Consumer<T> c) {
        this.consumer = c;
        return this;
    }

    /**
     * Metodo invocado cuando se produce algun cambio
     * en el objeto observado
     */
    @Override
    public void update() {
        if (predicate.test(elem))
            consumer.accept(elem);
    }
}