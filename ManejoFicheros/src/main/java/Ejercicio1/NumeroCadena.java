/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.Scanner;

/**
 *
 * @author Vespertino
 */
public class NumeroCadena {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dime un número por teclado: ");
        String nu = sc.nextLine();
        
        int num = Integer.parseInt(nu);
        if(nu instanceof String){
            System.out.println("Escribir números NO letras");
        }
        if(num>10){
            System.out.println("es mayor que 10");
        } else if(num<10){
            System.out.println("es menor que 10");
        } else{
            System.out.println("es igual que 10");
        }

    }
}
