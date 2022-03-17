/**
 * Ultima modificacion: 7/03/2022
 * 
 * Clase que crea y maneja un valor de lisp
 * @file Valor.java
 */

public class Valor extends Node{
    

	/**
	 * Regresa el tipo del valor
     * boolean = 0, float 1, string 2
	 */
    public int type(){
        return tipo; 
    }

    
	/**
	 * Construye un valor
     * @param t el tipo
     * @param d la data
	 */
    Valor(int t, String d){
        tipo = t;
        dataTot = d;
    }

	/**
	 * Construye un valor tipo float
	 */
    Valor(float va){
        tipo = 1;
        dataTot = String.valueOf(va);
        lista.add(this);
    }


	/**
	 * Construye un valor tipo string
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
