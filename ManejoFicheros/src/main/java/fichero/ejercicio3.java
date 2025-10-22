
import java.util.Scanner;



public class ejercicio3{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime un número entero: ");
        int num = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            
            int multi=num*(i+1);
            System.out.println(num+" x "+(i+1)+" = "+multi);

        }
    }

}