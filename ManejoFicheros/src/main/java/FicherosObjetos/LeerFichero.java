/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosObjetos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Vespertino
 */
public class LeerFichero {
    public static void main(String[] args){
        Persona p1 = new Persona();
        try(BufferedReader br = new BufferedReader(new FileReader ("ObjPers.txt"))){
            
            
            String linea;
            int count = 0; 
            while((linea = br.readLine())!=null){
                
                if((count == 0)&&(linea instanceof String)){
                    
                    if(linea.trim().isEmpty()){
                        System.out.println("El nombre no puede estar vacío");
                    }
                    //Asigno el nombre al objeto 
                    p1.setNombre(linea.trim());
                    
                } else if((count == 1)){
                    
                    int edad = Integer.parseInt(linea);
                    if(edad<=0){
                        System.out.println("La edad tiene que ser un número realista");
                    }
                    //Asigno la edad al objeto 
                    p1.setEdad(edad);
                    
                } else if((count == 2) && (linea instanceof String)){
                    
                    if(linea.trim().isEmpty()){
                        System.out.println("El email no puede estar vacío");
                    }
                    //Asigno el email al objeto 
                    p1.setEmail(linea);
                }
                count++;
            }
            
            
            //Este es otro try catch para escribir un nuevo fichero
            try(FileWriter fw = new FileWriter("EscribirObjPers.txt")){
                
                
                fw.write("Nombre: "+p1.getNombre()+"\n");
                fw.write("Edad: "+p1.getEdad()+"\n");
                fw.write("Email: "+p1.getEmail()+"\n");
                
                fw.close();
                
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            
            
            
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
