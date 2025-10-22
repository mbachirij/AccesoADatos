package ManejoFicheros;

import java.io.*;

public class Ejer2_mohammedBachiriJabbouri {

    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new FileReader("datos.txt"))){

            String linea;
            int contador = 0;

            while((linea = br.readLine())!=null){

                try{
                    contador += Integer.parseInt(linea);
                } catch (NumberFormatException e){
                    System.out.println("Solo se aceptan números");
                }
            }

            FileWriter fw = new FileWriter("datos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Suma total = "+contador);
            pw.close();
            fw.close();

        } catch (FileNotFoundException ex){
            System.out.println("No se pudo encontrar el fichero");
        } catch(IOException e){
            System.out.println("No se pudo leer el fichero");
        }

    }

}
