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

    private Quantity(String abbrev){
        this.abbrev = abbrev;
    }

    @Override
    public String toString(){
        return abbrev;
    }
}