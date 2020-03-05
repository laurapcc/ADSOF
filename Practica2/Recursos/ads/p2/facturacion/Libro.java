/**
 * Clase Libro
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */

package ads.p2.facturacion;

/**
 * Clase de tipo Libro que hereda de Articulo
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Libro extends Articulo {
    private String category;

    /**
     * Constructor: crea un objeto de tipo Libro con los parametros pasados
     * @param id un número entero: identificador
     * @param desc una cadena de caracteres: descripcion del alimento
     * @param precio un número decimal
     * @param category una cadena de caracteres: categoria del libro
     */
    public Libro(long id, String desc, double precio, String category) {
        super(id, desc, precio);
        this.category = category;
    }

    /**
     * Devuelve el precio de un articulo de dicho objeto
     * 
	 * @return atributo category (String) del libro
     */
    public String getCategory() { return category; }

    /**
     * Actualiza el atributo category del libro
	 * 
	 * @param category String 
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Tipo de IVA general aplicable es 4%
     * 
	 * @return porcentaje (double) de IVA que se aplica a Libro
     */
    public double tipoIVA() { return 0.04; }

    /**
     * Descuento del 15% si es Libro de texto
     * Descuento del 50% a partir de la tercera unidad si es Libro de coleccion
     * 
     * @param unidades numero de unidades del objeto libro
	 * @return descuento (double) como porcentaje que se aplica al alimento
     */
    public double descuento(double unidades) {
        if(category.equals("LibroDeTexto")) {
            return getPrecioUnitario() * 0.15 * (unidades);
        }
        else if(category.equals("Coleccion")) {
            if (unidades>=3) {
                return getPrecioUnitario() * 0.5 * (unidades-2);
            }
        }
        return 0.0;
    }
}
