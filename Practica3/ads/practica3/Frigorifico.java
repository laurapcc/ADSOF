package ads.practica3;

/**
 * Clase Frigorifico que hereda de ElectrodomesticoPesoDim
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Frigorifico extends ElectrodomesticoPesoDim {

    /**
     * Constructor: crea un objeto de tipo Frigorifico con los parametros pasados
     * 
     * @param marca  String: marca del frigorifico
     * @param modelo String: modelo del frigorifico
     * @param precio double: precio del frigorifico
     * @param peso double: peso del frigorifico
     * @param dim Dimension: dimensiones del frigorifico
     */
    public Frigorifico(String marca, String modelo, double precio, EficEnergetica claseEnergetica,
                 double peso, Dimension dim) {
        super(marca, modelo, precio, claseEnergetica, peso, dim);
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