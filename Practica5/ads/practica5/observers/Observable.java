package ads.practica5.observers;

/**
 * Interface Observable
 * 
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public interface Observable {
    /**
     * Añade un observador para que observe al propio objeto
     * 
     * @param observer observador
     * @param field nombre del campo que se pretende observar
     */
    public void attach(Observer observer, String field);

    /**
     * Notifica si se ha producido algun cambio en el campo field
     * a los observadores que esten observando ese campo
     * 
     * @param field nombre del campo
     */
    public void notifyAllObservers(String field);
}