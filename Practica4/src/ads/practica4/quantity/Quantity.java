package ads.practica4.quantity;

/**
 * Enumeracion Quantity
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public enum Quantity {
    LENGTH, TIME;

    /**
     * Método toString generico para el enumerado Quantity
     * 
     * @return : L si Quantity es de tipo LENGTH y t si es de
     * tipo TIME
     */
    @Override
    public String toString() {
        String ret = null;

        if (this == LENGTH)
            ret = "L";
        else if (this == TIME)
            ret = "t";
        return ret;
    }
}