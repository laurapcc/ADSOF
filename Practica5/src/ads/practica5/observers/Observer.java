package ads.practica5.observers;

/**
 * Interface Observer
 * 
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 */
public interface Observer {

    /**
     * Metodo invocado cuando se produce algun cambio
     * en el objeto observado
     */
    public void update();
}