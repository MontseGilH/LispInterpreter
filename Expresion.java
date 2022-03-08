import java.util.ArrayList;

/**
 * Ultima modificacion: 7/03/2022
 * 
 * Clase que crea y maneja una expresion de lisp
 * @file Expresion.java
 */

public class Expresion extends Node{
    
        
	/**
	 * Regresa el tipo de nodo
     * En este caso siempre sera 3, al ser una lista
	 */
    public int type(){
        return tipo;
    }

    
	/**
	 * Construye una lista de nodos
     * Esto es una expresion
     * @param lista a construir de nodos
	 */
    public Expresion(ArrayList<Node> listaNod){
        tipo = 3;
        lista = new ArrayList<Node>(listaNod);
		dataTot = "("; 
		for (Node n : lista) {
			dataTot += n.getDataTot() + " ";
		}
		dataTot = dataTot.substring(0, dataTot.length()-1);
		dataTot += ")";
    }
}
