/**
 * Ejemplo2
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
import ads.p2.facturacion.*;

/**
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Ejemplo2 {
  /**
   * Punto de entrada a la aplicación.
   *
	 * Este metodo imprime informacion sobre los objetos creados
   * @param args Los argumentos de la línea de comando
   */
  public static void main(String args[]) {
    Articulo a3 = new Libro(940111, "Dibujo Técnico", 15, "LibroDeTexto");
    Articulo a4 = new Libro(940607, "Grandes Clasicos", 10, "Coleccion");
    Libro a5 = new Libro(940607, "Fifty fifty", 3.25, "SinClasificar");
    Tabaco a6 = new Tabaco(690023, "Fortuna", 1.75);

    int cant = 2;
    System.out.println(cant + " unidades de " + a3 + " Precio final: " + a3.precioTotal(cant));
    cant = 5;
    System.out.println(cant + " unidades de " + a4 + " Precio final: " + a4.precioTotal(cant));
    cant = 4;
    System.out.println(cant + " unidades de " + a5 + " Precio final: " + a5.precioTotal(cant));
    cant = 1;
    System.out.println(cant + " unidades de " + a6 + " Precio final: " + a6.precioTotal(cant));
  }
}
