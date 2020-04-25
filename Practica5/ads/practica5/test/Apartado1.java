package ads.practica5.test;

import java.util.*;

import ads.practica5.graph.Graph;
import ads.practica5.elements.*;

/**
 * Tester apartado1
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public class Apartado1 {

    public static void main(String[] args) {
        
        Graph<String, Integer> g = new Graph<String, Integer>();
        Node<String> n1 = new Node<String>("s0");
        Node<String> n2 = new Node<String>("s1");
        
        g.addAll(Arrays.asList(n1, n2, n1)); // no admite repetidos, considerando igualdad referencial
        
        g.connect(n1, 0, n1); /// conectamos n1 con n1 a través de enlace con valor 0
        g.connect(n1, 1, n2);
        g.connect(n1, 0, n2);
        g.connect(n2, 0, n1);
        g.connect(n2, 1, n1);
        
        System.out.println(g); // El grafo contiene 2 nodos y 5 enlaces
        
        for (Node<String> n : g) // Colección de dos nodos (n1 y n2)
            System.out.println("Nodo " + n);
            
        List<Node<String>> nodos = new ArrayList<>(g); // podemos crear una lista a partir de g
        System.out.println(nodos);
        
        // Dos métodos para chequeo de conexión, la primera recibe el valor del Nodo
        System.out.println("s0 conectado con ‘s1’: "+ n1.isConnectedTo("s1"));
        System.out.println("s0 conectado con s1: "+ n1.isConnectedTo(n2));
        System.out.println("vecinos de s0: "+n1.neighbours());
        System.out.println("valores de los enlaces desde s0 a s1: " + n1.getEdgeValues(n2));
    }
}