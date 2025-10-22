
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class ejercicio1{

    public static void main(String[] args){

        try {
            FileReader fr = new FileReader("texto.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            int count = 0;



            if (linea !=null) {
                
                for (int i = 0; i < linea.length(); i++) {
                    
                    if(linea.charAt(i)=='a'){
                        count++;
                    }

                }

                System.out.println("El número de 'a' es: "+count);

            } else {
                System.out.println("El archivo está vacío");
            }

        } catch (IOException e) {
            System.out.println("Error"+e.getMessage());
        }


    }

}