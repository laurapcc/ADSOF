package ads.practica4.units.ICompositeUnit;

/**
 * Enumeracion Operator
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public enum Operator {
    MUL("*"), DIV("/");

    private String abbrev;		

    /**
     * Constructor privado para el enumerado Quantity
     * 
     * @param abbrev : abreviatura del elemento de Quantity creado
     */
    private Operator(String abbrev){		
        this.abbrev = abbrev;		
    }

    /**
     * Método toString generico para el enumerado Quantity
     * 
     * @return : * si Operator es de tipo MUL y / si es de
     * tipo DIV
     */
    @Override
    public String toString(){
        return abbrev;
    }
}