package ads.practica4.magnitude.exceptions;

/**
 * Excepcion QuantityException
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class QuantityException extends Exception {

    /**
     * Constructor de la excepcion
     * 
     * @param mssg : mensaje explicatorio del origen de la excepcion
     */
    public QuantityException(String mssg) {
        super(mssg);
    }

    /**
     * Devuelve el mensaje de QuantityException
     * 
     * @return : Mensaje asociado a la excepcion
     */
    @Override
    public String toString(){
        return getMessage();
    }
}