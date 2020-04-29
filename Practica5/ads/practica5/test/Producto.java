package ads.practica5.test;

import java.util.concurrent.TimeUnit;
import java.util.*;

import ads.practica5.observers.Observable;
import ads.practica5.observers.Observer;

/**
 * Clase producto usada para los tester
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 */
public class Producto implements Observable {

    private double precio;
    private Date caducidad;
    private Map<Observer, String> observers = new HashMap<>();

    /**
     * Constructor de la clase producto
     * 
     * @param p precio del producto
     * @param date fecha de caducidad
     */
    public Producto (double p, Date date) { 
        this.precio = p;
        this.caducidad = date;
    }

    /**
     * Devuelve el precio del producto
     * 
     * @return precio del producto
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Establece el precio de un producto notificando a los
     * observadores por si se ha producido el cambio esperado
     * 
     * @param p precio del producto
     */
    public void setPrecio(double p) {
        this.precio = p;
        notifyAllObservers("precio");
    }

    /**
     * Devuelve la fecha de caducidad del producto
     * 
     * @return caducidad
     */
    public Date getCaducidad() {
        return this.caducidad;
    }

    /**
     * Calcula la diferencia de dos fechas distintas
     * 
     * @param date primera fecha que se quiere comparar
     * @param date2 segunda fecha que se quiere comparar
     * @param timeUnit unidad de teimpo en la que se quiere hacer
     * la comparacion
     * @return diferencia entre date y date2 en la unidad timeUnit
     */
    public static long getDateDiff(java.util.Date date, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    /**
     * Override del metodo generico toString
     */
    @Override
    public String toString() {
        return this.precio+", caducidad: "+this.caducidad;
    }

    /**
     * Añade un observador para que observe al propio objeto
     * 
     * @param observer observador
     * @param field campo que se esta observando
     */
    @Override
    public void attach(Observer observer, String field) {
        observers.put(observer, field);
    }

    /**
     * Notifica algun cambio producido en el objeto a todos los
     * observadores
     * 
     * @param field campo que se esta observando
     */
    @Override
    public void notifyAllObservers(String field) {
        for (Observer observer : observers.keySet()) {
            if (field.equals(observers.get(observer)))
                observer.update();
        }
    }
}