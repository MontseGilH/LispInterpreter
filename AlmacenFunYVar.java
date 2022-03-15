/**
 * Ultima modificacion: 1/03/2022
 * 
 * Clase que almacena funciones y variables definidas anteriormente
 * @file AlmacenFunYVar.java
 */
//import java.util.ArrayList;
import java.util.HashMap;

public class AlmacenFunYVar {
    public static HashMap<String, Node> variables = new HashMap<String,Node>();
    public static HashMap<String, Node> funciones = new HashMap<String,Node>();

    /**
	 * Regresa las funciones
	 */
    public static HashMap<String, Node> getFunciones() {
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
    public static void addFuncion(String nombre, Node funcion){
        funciones.put(nombre,funcion);
    }

    /**
	 * Regresa las variables
	 */
    public static HashMap<String, Node> getVariables() {
        return variables;
    }


}
