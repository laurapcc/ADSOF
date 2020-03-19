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
                boolean flag = false;
                Electrodomestico e;
                String[] aux = line.split("=");
                if (aux.length == 5)
                    e = crearTelevision(aux);
                else if (aux.length == 9)
                    e = crearFrigorifico(aux);
                else if (aux.length == 10)
                    e = crearLavadora(aux);
                else {
                    System.out.printf("Linea no procesada\n");
                    continue;
                }
                for (Electrodomestico ele : productos) {
                    if (ele.equals(e)) {
                        System.out.printf("Duplicado no añadido:\n");
                        System.out.printf(e.toString()+"\n");
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    productos.add(e);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }

    /**
     * Crea un un objeto de tipo Television cuyos arguemntos se pasan mediante
     * un array de tipo String
     * 
     * @param info array de tipo Strign con los argumentos de entrada
     * @return objeto Electrodomestico creado
     */
    public static Television crearTelevision(String[] info) {
        String marca = info[0];
        String modelo = info[1];
        double precio = Double.parseDouble(info[2]);
        ClaseEnergetica claseEnergetica = ClaseEnergetica.valueOf(info[3]);
        double pantalla = Double.parseDouble(info[4]);
        
        return new Television(marca, modelo, precio, claseEnergetica, pantalla);
    }

    /**
     * Crea un un objeto de tipo Frigorifico cuyos arguemntos se pasan mediante
     * un array de tipo String
     * 
     * @param info array de tipo Strign con los argumentos de entrada
     * @return objeto Electrodomestico creado
     */
    public static Frigorifico crearFrigorifico(String[] info) {
        Frigorifico f = null;
        String marca = info[0];
        String modelo = info[1];
        double precio = Double.parseDouble(info[2]);
        ClaseEnergetica claseEnergetica = ClaseEnergetica.valueOf(info[3]);
        Dimension dim = new Dimension(Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
        double peso = Double.parseDouble(info[7]);

        if (info[8].equals("NoFrost"))
            f = new Frigorifico(marca, modelo, precio, claseEnergetica, dim, peso, false);
        else
            f = new Frigorifico(marca, modelo, precio, claseEnergetica, dim, peso, true);

        return f;
    }

    /**
     * Crea un un objeto de tipo Lavadora cuyos arguemntos se pasan mediante
     * un array de tipo String
     * 
     * @param info array de tipo Strign con los argumentos de entrada
     * @return objeto Electrodomestico creado
     */
    public static Lavadora crearLavadora(String[] info) {
        String marca = info[0];
        String modelo = info[1];
        double precio = Double.parseDouble(info[2]);
        ClaseEnergetica claseEnergetica = ClaseEnergetica.valueOf(info[3]);
        Dimension dim = new Dimension(Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
        double peso = Double.parseDouble(info[7]);
        double cargaKg = Double.parseDouble(info[8]);
        int rpm = Integer.parseInt(info[9]);
        
        return new Lavadora(marca, modelo, precio, claseEnergetica, dim, peso, cargaKg, rpm);
    }
}
