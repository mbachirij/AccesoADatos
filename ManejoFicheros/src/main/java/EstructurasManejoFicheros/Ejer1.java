/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasManejoFicheros;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vespertino
 */
public class Ejer1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double cal;
        
        double[] arrayCal = new double[10];
        int contador = 0;
        double suma = 0;
        for(int i=0; i<=9; i++){
            System.out.println("Dame la calificación nº "+i);
            cal = sc.nextDouble();
            
            arrayCal[i] = cal;
            suma+=cal;
            contador++;
            
        }
        
        double mayor = 0;
        double menor = 0;
        
        
        
        
        for(int i=0; i<arrayCal.length; i++){
            if(arrayCal[i]>=mayor){
                mayor=arrayCal[i];
            }
        }
        
        for(int i=0; i<arrayCal.length; i++){
            if(arrayCal[i]<=mayor){
                menor=arrayCal[i];
            }
        }
        
        System.out.println("EL mayor es "+ mayor);
        System.out.println("EL menor es "+ menor);
        System.out.println("El promedio es "+(suma/contador));
        
        try(FileWriter fw = new FileWriter("resultados.txt")){
            
            fw.write("EL mayor es "+ mayor);
            fw.write("EL menor es "+ menor);
            fw.write("El promedio es "+(suma/contador));
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}
