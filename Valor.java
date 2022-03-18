/**
 * Ultima modificacion: 18/03/2022
 * 
 * Clase que crea y maneja un valor de lisp
 * @file Valor.java
 */

public class Valor extends Node{
    
	/**
	 * Regresa el tipo del valor
     * boolean 0, float 1, string 2
	 */
    public int type(){
        return tipo; 
    }

	/**
	 * Construye un valor tipo float
     * @param va float con el valor del valor
	 */
    Valor(float va){
        tipo = 1;
        dataTot = String.valueOf(va);
        lista.add(this);
    }


	/**
	 * Construye un valor tipo string
     * @param va string con el valor del valor
	 */
    Valor(String va){
        tipo = 2;
        dataTot = va;
        lista.add(this);
    }


	/**
	 * Construye un valor tipo boolean
     * @param va true = t, false = nul
	 */
    Valor(boolean va){
        tipo = 0;
        if (va){
            dataTot = "T";
        } else {
            dataTot = "NIL";
        }
        lista.add(this);
    }

}
