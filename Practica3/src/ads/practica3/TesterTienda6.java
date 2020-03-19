package ads.practica3;

/**
 * Tester del apartado 6 (opcional) de la practica 3
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class TesterTienda6 {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Electrodomestico tele1 = new Television("Loewe", "Art 48 4K Plata", 1699.00,
                                                ClaseEnergetica.A, 48);
        Electrodomestico tele2 = new Television("LG", "32LF592U", 271.92,
                                                ClaseEnergetica.C, 32);
        Electrodomestico lava1 = new Lavadora("Indesit", "XWE 91483 X", 329.0,
                                              ClaseEnergetica.A, new Dimension(59.5, 60.5, 85.0), 72, 9.5, 1500);
        Electrodomestico frigo1 = new Frigorifico("Bosch", "KGN39VW21", 599.0,
                                                  ClaseEnergetica.A, new Dimension(60, 65, 201), 83.0, true);
        Electrodomestico telec1 = new TelevisionCurva("P", "E2000", 1299.99, ClaseEnergetica.B, 52, new Dimension(120, 30, 75), 18);

        almacen.anadirProducto(tele1);
        almacen.anadirProducto(tele2, 3);
        almacen.anadirProducto(lava1, 2);
        almacen.anadirProducto(frigo1);
        
        System.out.print(almacen.mostrarInventario());
        

        almacen.nuevaVenta(new VentaCanarias(tele1));
        almacen.nuevaVenta(new VentaDomicilio(tele1)); // no hay stock
        almacen.nuevaVenta(new Venta(tele2, 
                            new Lavadora("Superkin", "", 0.0, ClaseEnergetica.Desconocida, 
                                           new Dimension(59.5, 60.5, 85.0), 100))); 
        almacen.nuevaVenta(new VentaDomicilio(lava1, frigo1));
        almacen.nuevaVenta(new Venta(tele2, new Television("Telefunken", "", 0.0, ClaseEnergetica.D, 32)));
        almacen.nuevaVenta(new VentaDomicilio(lava1, tele2));
        almacen.nuevaVenta(new VentaCanarias(telec1)); // no hay stock
        almacen.nuevaVenta(new Venta(frigo1, telec1));
        
        System.out.print(almacen.mostrarInventario());
    }
}
