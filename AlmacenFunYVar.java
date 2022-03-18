/**
 * Ultima modificacion: 18/03/2022
 * 
 * Clase que almacena funciones y variables definidas anteriormente
 * Esta clase es static para poder acceder a las variables y funciones guardadas desde cualquier punto del programa
 * @file AlmacenFunYVar.java
 */

import java.util.HashMap;

public class AlmacenFunYVar {

    public static HashMap<String, Node> variables = new HashMap<String,Node>();
    public static HashMap<String, Funcion> funciones = new HashMap<String,Funcion>();
    
    /**
	 * Regresa las funciones
     * @return 
	 */
    public static HashMap<String, Funcion> getFunciones() {
        return funciones;
    }

    /**
	 * Añade una variable al map con las variables y sus nombres
     * @param nombre nombre de la variable
     * @param valor nodo con el valor de la variable
	 */
    public static void addVar(String nombre, Node valor){
        variables.put(nombre,valor);
    }

     /**
	 * Añade una variable al map con las variables y sus nombres
     * @param nombre nombre de la variable
     * @param valor nodo con el valor de la funcion
	 */
    public static void addFuncion(String nombre, Funcion funcion){
        funciones.put(nombre,funcion);
    }

    /**
	 * Regresa las variables
     * @return
	 */
    public static HashMap<String, Node> getVariables() {
        return variables;
    }


}
