package ads.practica3;

/**
 * Clase Lavadora que hereda de ElectrodomesticoPesoDim
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Lavadora extends ElectrodomesticoPesoDim {

    /**
     * Constructor: crea un objeto de tipo Lavadora con los parametros pasados
     * 
     * @param marca  String: marca de la lavadora
     * @param modelo String: modelo de la lavadora
     * @param precio double: precio de la lavadora
     * @param peso double: peso de la lavadora
     * @param dim Dimension: dimensiones de la lavadora
     */
    public Lavadora(String marca, String modelo, double precio, EficEnergetica claseEnergetica,
                 double peso, Dimension dim) {
        super(marca, modelo, precio, claseEnergetica, peso, dim);
    }

    /**
     * Calcula el precio de envio para un electrodomestico de tipo lavadora
     * @return double: precio del envio para lavadoras
     */
    @Override
    public double precioPorte(){
        if (getPeso() <= 50)
            return 35;
        return 35+Math.ceil(getPeso()-50)*0.5;
    }

}