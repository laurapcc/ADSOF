/**
* Esta aplicación comprueba cada numero en una lista es primo
* e imprime todos los primos encontrados hasta el mayor de esos numeros
*
* @author Laura de Paz Carbajo laura.pazc@uam.es
* @author Rubén García de la Fuente ruben.garciadelafuente@uam.es
*
*/


import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Esta clase mantiene una caché de números primos, para
 * evitar cálculos repetidos, y calcula si un número es primo
 * La cache conserva los primos calculados
 */
public class Primos {
    // usamos un conjunto ordenado, que implementa TreeSet
    private SortedSet<Integer> primos= new TreeSet<>();
    private int max=1;

    /**
     *
     * @return cache con los primos calculados
     */
    public SortedSet<Integer> getPrimos(){
        return primos;
    }

    public String toString(){
        return "Primos hasta "+ max+ " = "+primos;
    }

    /**
     *
     * @param n un número entero
     * @return si n es primo
     */
    public boolean esPrimo(int n){
        if (n<2) return false;
        if (n>max) actualizaPrimos(n);
        return primos.contains(n);
    }


    
    /**
     * Este método llama a compruebaPrimo, y lo añade, si es primo,
     * para todos los números entre max+1 y n. Actualiza max al terminar.
     * @param n
     */
    private void actualizaPrimos(int n){
        for(int i = max+1; i <= n; i++){
            if (compruebaPrimo(i) == true) primos.add(i);
        }
        
        if (n > max) max = n;
    }

    /**
     * Comprueba si n es primo, asumiendo que el conjunto primos
     * está actualizado con todos los anteriores
     * @param n valor a comprobar
     * @return si n es primo
     */
    private boolean compruebaPrimo(int n){
        for (int d: primos){
            if (n%d == 0) return false;
        }
        return true;
    }

    
    /**
     * Punto de entrada a la aplicación.
     *
     * Este comprueba si los números de la línea de comando son primos
     * Al final imprime todos los primos hasta el número más grande pasado
     * @param args Los argumentos de la línea de comando. Se esperan números enteros, como cadenas
     */
    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Se espera al menos un número como parámetro");
        }
        else{
            Primos pr = new Primos();
            for(String s: args){
                boolean b = pr.esPrimo(Integer.parseInt(s));
                if (b == true) System.out.println(s+" es primo");
                else System.out.println(s+" no es primo");
                System.out.println(pr);
            }
            
        }
    }

}
