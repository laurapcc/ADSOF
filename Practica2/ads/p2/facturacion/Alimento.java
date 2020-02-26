/**
 * Clase Alimento
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */

package ads.p2.facturacion;

/**
 * Clase de tipo Alimento que hereda de Articulo
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Alimento extends Articulo {
		private boolean promo3x2;
		
		/**
     * Constructor: crea un objeto de tipo alimento con los parametros pasados
     * @param id un número entero: identificador
		 * @param desc una cadena de caracteres: descripcion del alimento
		 * @param precio un número decimal
		 * @param promo boolean
     */
	  public Alimento(long id, String desc, double precio, boolean promo) {
				super(id, desc, precio);
				promo3x2 = promo;
		}
		
		/**
     * 
		 * @return atributo promo (boolean) de alimento
     */
		public boolean getPromo3x2() { return promo3x2; }
		
		/**
     * Actualiza el atributo promo de alimento
		 * 
		 * @param promo boolean
     */
		public void setPromo3x2(boolean promo) { promo3x2 = promo; }

		/**
     * 
		 * @return porcentaje (double) de IVA que se aplica a Alimento
     */
		public double tipoIVA() { return 0.10; }
		
		/**
     * @param unidades 
		 * @return descuento (double) como porcentaje que se aplica al alimento
     */
	  public double descuento(double unidades) {
	      if (promo3x2) return getPrecioUnitario() * (int) (unidades / 3);
	      else return 0.0;		
	  }
}
