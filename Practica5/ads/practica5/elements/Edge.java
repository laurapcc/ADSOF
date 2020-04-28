package ads.practica5.elements;

/**
 * Clase Edge
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Edge<S> {

    private S value;
    Node<?> n1;
    Node<?> n2;

    /**
     * Constructor de la clase Edge
     * 
     * @param n1 nodo origen del enlace
     * @param value valor del enlace
     * @param n2 nodo destino del enlace
     */
    public Edge(Node<?> n1, S value, Node<?> n2){
        this.n1 = n1;
        this.value = value;
        this.n2 = n2;
    }

    /**
     * Devuelve el nodo de partida del enlace
     * 
     * @return : Node
     */
    public Node<?> getOrigin() {
        return n1;
    }

    /**
     * Devuelve el nodo de llegada del enlace
     * 
     * @return : Node
     */
    public Node<?> getDest() {
        return n2;
    }

    /**
     * Devuelve el valor correspondiente al enlace actual
     * 
     * @return : informacion
     */
    public S getValue(){
        return value;
    }

    /**
     * Override del método generico toString
     * 
     * @return : String
     */
    @Override
    public String toString() {
        String cadena = "( " + n1.getId() + " --" + value.toString() + "--> " + n2.getId() + " )";
        return cadena;
    }
}