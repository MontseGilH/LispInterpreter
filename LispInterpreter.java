/**
 * Ultima modificacion: 1/03/2022
 * 
 * Clase main del interprete
 * @file LispInterpreter.java
 */
import java.util.Scanner;

public class LispInterpreter {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean terminar = false;
        System.out.println("Bienvenid@ al interprete de lisp\n");
        while (!terminar){
            System.out.println(">>");
            String enunciado = scan.nextLine();
            if (enunciado.equalsIgnoreCase("end")){
                terminar = true;
            }
        }
    
        scan.close();
    }
}
