import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2{

    public static void main(String[] args) {
        

            try{
                FileReader fr = new FileReader("texto2.txt");
                BufferedReader br = new BufferedReader(fr); 
                    String linea=br.readLine();
                    
                    while (linea != null && !linea.equals("salir")) {
                        
                        System.out.println(linea.toUpperCase());
                        linea = br.readLine();
                    }
                

            } catch(IOException e){
                System.out.println("Error "+e.getMessage());
            }




    }

}