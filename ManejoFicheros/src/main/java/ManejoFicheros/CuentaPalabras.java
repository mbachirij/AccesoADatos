/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Vespertino
 */
public class CuentaPalabras {
    
    public static void main(String[] args){
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("contador.txt"))) {
            TreeMap<String, Integer> palabras = new TreeMap<>();
            
            String linea;
            while ((linea = br.readLine()) != null) {
                //Esto no se hace con split debes, ademos de que esta mal escrito
                //SI lo quieres hacer con split debe ser asi
                //String[] palabraLinea = linea.split(" "); Lee la linea y la separa las lineas por espacios
                String[] palabrasLinea = linea.split("\\s+");
                // Debes de usar el StringTokenizer, aunque haga lo mismo que el split dijo que debiamos usar esto.
                //StringTokenizer st = new StringTokenizer(linea);
                //Tambien mejor si usas ArrauList() mucho mas comodo y flexible
                
                for (String palabra : palabrasLinea) {
                    if (palabra.isEmpty()) continue; //Esto no hace falta porque no puede agregar palabras en blaco porue ya usa el split para descartar los espacios,
                    palabra = palabra.toLowerCase();
                    /*Debes crear un if, en caso de que no contenga la palabra la agrega al TreeMap y con un contador de 1 y en caso de ya tenerla solo le suma 1 a ese contador
                    if(palabras.containsKey(palabra)){
                        palabras.put(palabra, palabras.get(palabra)+1);
                    }else{
                        palabras.put(palabra,1);
                    }
                    */
                    palabras.put(palabra, palabras.getOrDefault(palabra, 0) + 1); //Capaz me equivoco pero esto lo sacaste de ChatGPT? jajajaja
                }
                
            }
            
            /*Seria mucho mas recomendable separar cada parte para que lo veas claro, ademas de usar PrintWriter para no necesitar añadir "bw.newLine()"
            File f = new File("Contador.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            */
            for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
                //pw.println(entry.getKey() + ": " + entry.getValue());
                
                bw.write(entry.getKey() + ": " + entry.getValue());
                bw.newLine();
                //pw.flush(); Esto puedes usarlo dentro o fuera del for 
            }
            //pw.close(); Tambien esto para cerrarlo

            System.out.println("Archivo 'contador.txt' creado correctamente.");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
