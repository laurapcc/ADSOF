/**
 * Clase Tabaco
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */

package ads.p2.facturacion;



/**
 * Clase de tipo Tabaco que hereda de Articulo
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Tabaco extends Articulo {
    /**
     * Constructor: crea un objeto de tipo Libro con los parametros pasados
     * @param id un número entero: identificador
     * @param desc una cadena de caracteres: descripcion del alimento
     * @param precio un número decimal
     */
    public Tabaco(long id, String desc, double precio) {
        super(id, desc, precio);
    }

    /**
     * @param unidades 
	 * @return descuento (double) como porcentaje que se aplica al alimento
     */
    public double descuento(double unidades) {
        return 0.0;
    }
}
