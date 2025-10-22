/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasManejoFicheros;

/**
 *
 * @author Vespertino
 */
public class Ejer2 {
    public static void main(String[] args){
        
        int[] numeros = new int[50];
        
        for(int i=0; i< numeros.length; i++){
            
            numeros[i]=(int)(Math.random()*25);
            
        }
        
        
        System.out.println("Array con duplicados");
        for(int su: numeros){
            System.out.print(su+" ");
        }
        
        int[] numeSin = new int[50];
        
        for(int i=0; i<numeros.length; i++){
            
            for(int j=0; j<i; j++){
                
                if(!(numeros[j]==numeros[i+1])){
                    numeSin[i]=numeros[j];
                } 
                
            }
            
        }
        
        System.out.println();
        System.out.println("Array sin duplicados");
        for(int su: numeSin){
            System.out.print(su+" ");
        }
        
        
        
    }
}
