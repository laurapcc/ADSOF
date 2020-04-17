package ads.practica5.graph;

/**
 * Clase Node
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Node<A> {

    A info;
    //edges del tipo del segundo generico de graph

    public Node(A info){
        this.info = info;
    }

    public boolean isConnectedTo(A id){
        return true;
    }

    // neighbours

    // getEdgeValues
}
