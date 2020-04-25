package ads.practica5.elements;

/**
 * Clase Edge
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Edge<S> {

    private S info;
    Node<?> n1;
    Node<?> n2;
    //edges del tipo del segundo generico de graph

    public Edge(Node<?> n1, S info, Node<?> n2){
        this.n1 = n1;
        this.info = info;
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
     * Devuelve la informacion correspondiente al enlace actual
     * 
     * @return : informacion
     */
    public S getValue(){
        return info;
    }

    /**
     * Override del método generico toString
     * 
     * @return : String
     */
    @Override
    public String toString() {
        String cadena = "( " + n1.getId() + " --" + info.toString() + "--> " + n2.getId() + " )";
        return cadena;
    }
}