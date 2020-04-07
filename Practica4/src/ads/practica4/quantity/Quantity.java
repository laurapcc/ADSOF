package ads.practica4.quantity;

/**
 * Enumeracion Quantity
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public enum Quantity {
    LENGTH("L"), TIME("t");

    private String abbrev;		

    /**
     * Constructor privado para el enumerado Quantity
     * 
     * @param abbrev : abreviatura del elemento de Quantity creado
     */
    private Quantity(String abbrev){		
        this.abbrev = abbrev;		
    }

    /**
     * Método toString generico para el enumerado Quantity
     * 
     * @return : L si Quantity es de tipo LENGTH y t si es de
     * tipo TIME
     */
    @Override
    public String toString(){
        return abbrev;
    }
}