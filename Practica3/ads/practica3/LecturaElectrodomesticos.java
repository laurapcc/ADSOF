package ads.practica3;

import java.util.*;
import java.io.*;

/**
 * Clase LecturaElectrodomesticos
 *
 * @author Laura de Paz laura.pazc@uam.es
 * @author Rubén García ruben.garciadelafuente@uam.es
 *
 */
public abstract class LecturaElectrodomesticos {

    /**
     * Lee líena a línea un fichero de entrada y llama ala función crearElectrodomestico para crear
     * un electrodoméstico nuevo con los argumentos pasados
     * 
     * @param file fichero del que queremos leer
     * @return lista con los productos de tipo Electrodomestico creado
     */
    public static List<Electrodomestico> leer(String file) {
        List<Electrodomestico> productos = new ArrayList<Electrodomestico>();
        BufferedReader buffer;
        
        try {
            buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            
            while((line = buffer.readLine()) != null){
                String[] aux = line.split("=");
                Electrodomestico e = crearElectrodomestico(aux);
                productos.add(e);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }

    /**
     * Crea un un objeto de tipo Electrodomestico cuyos arguemntos se pasan mediante
     * un array de tipo String
     * 
     * @param info array de tipo Strign con los argumentos de entrada
     * @return objeto Electrodomestico creado
     */
    public static Electrodomestico crearElectrodomestico(String[] info) {
        Electrodomestico e = null;
        String marca = info[0];
        String modelo = info[1];
        double precio = Double.parseDouble(info[2]);
        ClaseEnergetica claseEnergetica = ClaseEnergetica.valueOf(info[3]);

        if (info.length == 5){
            double pantalla = Double.parseDouble(info[4]);
            e = new Television(marca, modelo, precio, claseEnergetica, pantalla);
        }
        else{
            Dimension dim = new Dimension(Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
            double peso = Double.parseDouble(info[7]);
            if (info.length == 9){
                if (info[8].equals("NoFrost"))
                    e = new Frigorifico(marca, modelo, precio, claseEnergetica, dim, peso, false);
                else
                    e = new Frigorifico(marca, modelo, precio, claseEnergetica, dim, peso, true);
            }
            else if (info.length == 10){
                double cargaKg = Double.parseDouble(info[8]);
                int rpm = Integer.parseInt(info[9]);
                e = new Lavadora(marca, modelo, precio, claseEnergetica, dim, peso, cargaKg, rpm);
                // no se si hay que añadir tbn la lavadora sin carga ni rpm (el otro oconstructor) 
            }
        }

        return e;
    }

}
