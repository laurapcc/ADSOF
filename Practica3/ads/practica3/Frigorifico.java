package ads.practica3;

/**
 * Clase Frigorifico que hereda de ElectrodomesticoPesoDim
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Frigorifico extends ElectrodomesticoPesoDim {

    private boolean frost;
    /**
     * Constructor: crea un objeto de tipo Frigorifico con los parametros pasados
     * 
     * @param marca  String: marca del frigorifico
     * @param modelo String: modelo del frigorifico
     * @param precio double: precio del frigorifico
     * @param peso double: peso del frigorifico
     * @param dim Dimension: dimensiones del frigorifico
     * @param frost boolean: si el frigorifico es frost o no
     */
    public Frigorifico(String marca, String modelo, double precio, EficEnergetica claseEnergetica,
                        Dimension dim, double peso, boolean frost) {
        super(marca, modelo, precio, claseEnergetica, dim, peso);
        this.frost = frost;
    }

    public boolean getFrost() {
        return this.frost;
    }

    public void setFrost(boolean frost) {
        this.frost = frost;
    }

    /**
     * Calcula el precio de envio para un electrodomestico de tipo Frigorifico
     * @return double: precio del envio para frigorificos
     */
    @Override
    public double precioPorte(){
        return getDim().volumen()*70;
    }

}