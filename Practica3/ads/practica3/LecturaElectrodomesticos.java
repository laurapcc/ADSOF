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
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public List<Electrodomestico> leer(String file) throws IOException {
        List<Electrodomestico> productos = new ArrayList<Electrodomestico>();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        
        while((line = buffer.readLine()) != null){
            String[] aux = line.split("=");
            Electrodomestico e = crearElectrodomestico(aux);
            productos.add(e);
        }
        buffer.close();
        return productos;
    } 


    /**
     * 
     * @param info
     * @return
     */
    public Electrodomestico crearElectrodomestico(String[] info){
        Electrodomestico e = null;
        String marca = info[0];
        String modelo = info[1];
        double precio = Integer.parseInt(info[2]);
        EficEnergetica claseEnergetica = EficEnergetica.valueOf(info[3]);
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