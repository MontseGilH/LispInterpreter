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
    @Override
    public int type(){
        return tipo; 
    }

    
    
    
    
    
    
    
	/**
	 * Construye un valor
     * @param t el tipo
     * @param d la data
	 */
    public Valor(int t, String d){
        tipo = t;
        dataTot = d;
    }

	/**
	 * Construye un valor tipo float
	 */
    public Valor(float va){
        tipo = 1;
        dataTot = String.valueOf(va);
        lista.add(this);
    }


	/**
	 * Construye un valor tipo string
	 */
    public Valor(String va){
        tipo = 2;
        dataTot = va;
        lista.add(this);
    }


	/**
	 * Construye un valor tipo boolean
	 */
    public Valor(boolean va){
        tipo = 0;
        if (va){
            dataTot = "true";
        } else {
            dataTot = "false";
        }
        lista.add(this);
    }

}
