/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosnetbeans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Vespertino
 */
public class ejercicio4 {
    public static void main(String[] args) throws FileNotFoundException{
        
        char[] let = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        try(BufferedReader br = new BufferedReader(new FileReader("dni.txt"))){
            
            String linea = br.readLine();
            
            while(linea !=null){
                int num = Integer.parseInt(linea.trim());
            
                int res=num%23;
                char letra = let[res];
            
                try(FileWriter fw = new FileWriter("dniResultado.txt")){
                    fw.write("Su dni es: "+num+letra);
                }
            
            } 
            
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        
        
    }
}
