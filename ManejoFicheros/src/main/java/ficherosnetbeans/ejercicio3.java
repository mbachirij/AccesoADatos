/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ficherosnetbeans;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Vespertino
 */
public class ejercicio3{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        try(FileWriter fw = new FileWriter("tabla.txt")){
           
            
            System.out.println("Dime un número entero: ");
            int num = sc.nextInt(); 
            
            
        
            for (int i = 1; i < 10; i++) {
            
                int multi = num * (i);
                fw.write(num+" x "+(i)+" = "+multi+"\n");
                
            }
        }catch(IOException e){
            
            System.out.println("Error "+e.getMessage());
            
        }
    }

}
