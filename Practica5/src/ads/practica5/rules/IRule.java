package ads.practica5.rules;

import java.util.function.*;

/**
 * Interface IRule
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 * 
 * @param <T> objeto parametrizado
 */
public interface IRule<T> {
    /**
     * Establece como predicado de la regla cuando se puede ejecutar
     * 
     * @param p predicado
     * @return regla con el predicado actualizado
     */
    public IRule<T> when(Predicate<T> p);

    /**
     * Establece como consumible de la regla la accion a ejecutar
     * 
     * @param c consumible
     * @return regla con el consumible actualizado
     */
    public IRule<T> exec(Consumer<T> c);
}