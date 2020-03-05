/**
 * Clase Articulo
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */

package ads.p2.facturacion;

/**
 * Clase abstracta de tipo Articulo 
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public abstract class Articulo {
		private long identificador;
		private String descripcion;
		private double precioUnitario;

		/**
     * Constructor: crea un objeto de tipo Articulo con los parametros pasados
     * @param id un número entero: identificador
		 * @param desc una cadena de caracteres: descripcion del alimento
		 * @param precio un número decimal
     */
  	public Articulo(long id, String desc, double precio) {
				identificador = id; descripcion = desc; precioUnitario = precio;
		}

		/**
     * Devuelve el identificador del objeto
		 * 
		 * @return atributo identificador (long) de articulo
     */
		public long getIdentificador() { return identificador; }

		/**
     * Devuelve la descripcion del objeto
		 * 
		 * @return atributo descripcion (String) de articulo
     */
		public String getDescripcion() { return descripcion; }

		/**
     * Devuelve el precio de un articulo de dicho objeto
		 * 
		 * @return atributo precioUnitario (double) de articulo
     */
		public double getPrecioUnitario() { return precioUnitario; }

		/**
     * Actualiza el atributo decripcion de articulo
		 * 
		 * @param desc String
     */
		public void setDescripcion(String desc) { descripcion = desc; }
		public void setPrecioUnitario(double precio) { precioUnitario = precio; }

		/**
     * Tipo de IVA general aplicable es 21%  salvo que se redefina en una subclase
		 * 
		 * @return porcentaje (double) de IVA
     */
		public double tipoIVA() { return 0.21; }

		/**
		 * Metodo abstracto que calcula el descuento que corresponde a cada subclase
		 * de articulo
		 * 
     * @param unidades numero de unidades del objeto alimento 
		 * @return descuento (double) como porcentaje que se aplica al articulo
     */
		public abstract double descuento(double unidades);

		/**
		 * PrecioTotal de cada articulo, independiente de a que subclase pertenece
		 * 
     * @param unidades numero de unidades del objeto articulo
		 * @return precio total
     */
		public double precioTotal(double unidades) {
		return ((precioUnitario * unidades) - descuento(unidades))
										* (1.0 + tipoIVA());
		}

		/**
		 * Devuelve como cadena el formato para imprimir un Articulo
		 * 
		 * @return String
     */
		public String toString() {
			return "Id:" + identificador + " " + descripcion + " Precio: " + precioUnitario;
		}
}
