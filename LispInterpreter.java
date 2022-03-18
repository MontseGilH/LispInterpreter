/**
 * Ultima modificacion: 18/03/2022
 * 
 * Clase main del interprete
 * @file LispInterpreter.java
 */
import java.util.Scanner;

public class LispInterpreter {
    public static void main(String[] args){
        //iniciamos un lector y el scaner para poder recibir los mensajes del usuario
        Scanner scan = new Scanner(System.in);
        Lector lector = new Lector();
        //controla si el programa debe finalizar
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
                    System.out.println(nodo.getNodeEvaluated().getDataTot());
                    
                } catch (Exception e){
                    System.out.println("Error "+e.getMessage());
                }
            }
        }
    
        scan.close();
    }
}
