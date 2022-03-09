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
        Lector lector = new Lector();
        boolean terminar = false;
        System.out.println("Bienvenid@ al interprete de lisp\n");
        while (!terminar){
            System.out.println(">>");
            String enunciado = scan.nextLine();
            if (enunciado.equalsIgnoreCase("fin")){
                terminar = true;
            } else {
                try{
                    Node nodo = lector.stringANode(enunciado);
                    //System.out.println(nodo.dataTot);
                    System.out.println(nodo.tipo);
                    System.out.println(nodo.lista);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    
        scan.close();
    }
}
