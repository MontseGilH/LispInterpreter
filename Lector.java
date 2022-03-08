//import java.util.ArrayList;


/**
 * Ultima modificacion: 1/07/2022
 * 
 * Clase que interpreta un string en listas
 * @file Lector.java
 */


public class Lector {
    public boolean revisaExpresion(String s){

        // verificar que el string sea un enunciado y este en notacion lisp
        if (s == null || s.length() == 0){
           return false;
        } else if (s.length()<= 4){
            return false;
        } else {
            if (!String.valueOf(s.charAt(0)).equals("(")){
                return false;
            } else if (!String.valueOf(s.charAt(s.length()-1)).equals(")")){
                return false;
            }
        }

        //revisar cuantos parentesis hay 
        String[] caracteres = s.split("");
        int inicioP = 0; //lleva el conteo de inicio de parentesis
        int finalP = 0; //lleva el conteo de final de parentesis

        for (String f:caracteres){
            if (f.equals("(")){
                inicioP ++;
            } else if (f.equals(")")){
                finalP++;
            }
        }
        return inicioP == finalP;

    }

    
}
