package ads.practica5.test;

import ads.practica5.rules.*;

import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Producto { // Una clase para probar las reglas
    private double precio;
    private Date caducidad; // Otra opción es usar Calendar
    
    public Producto (double p, Date c) { 
        this.precio = p;
        this.caducidad = c;
    }

    public double getPrecio()       { return this.precio; } 
    public void setPrecio(double p) { this.precio = p; }
    public Date getCaducidad()      { return this.caducidad; }
     
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    @Override public String toString() { return this.precio+", caducidad: "+this.caducidad; } 

}


public class Apartado3 {
    public static void main(String...args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        RuleSet<Producto> rs = new RuleSet<Producto>(); // Un conjunto de reglas aplicables sobre Productos

        rs.add(
            Rule.<Producto>rule("r1", "Rebaja un 10% los productos con fecha de caducidad cercana o pasada").
                when(pro -> Producto.getDateDiff(Calendar.getInstance().getTime(), pro.getCaducidad(), TimeUnit.DAYS) < 2 ).
                exec(pro -> pro.setPrecio(pro.getPrecio()-pro.getPrecio()*0.1)) 
            ).add(
                Rule.<Producto>rule("r2", "Rebaja un 5% los productos que valen más de 10 euros"). when(pro -> pro.getPrecio() > 10).
                exec(pro -> pro.setPrecio(pro.getPrecio()-pro.getPrecio()*0.05))
        );

        List<Producto> str = Arrays.asList( new Producto(10, sdf.parse("15/04/2020")), // parseamos a un Date
                                            new Producto(20, sdf.parse("20/03/2021"))); 
        
        rs.setExecContext(str); // indicamos que el conjunto de reglas rs se ejecutará sobre str
        rs.process(); // ejecutamos el conjunto de reglas 
        
        System.out.println(str); // imprimimos str
    }
     
}