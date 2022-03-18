import java.util.ArrayList;

/**
 * Ultima modificacion: 18/03/2022
 * 
 * Clase que crea una funcion
 * @file Funcion.java
 */

public class Funcion {
    private ArrayList<String> variables;
    private String funcion;

    /**
	 * Constructor
     * @param vars nombres de las variables
     * @param fun string que define la funcion
	 */
    Funcion(ArrayList<String> vars,String fun){
        variables = vars;
        funcion =fun;
    }

    /**
	 * Regresa los nombres de las variables de la funcion
     * @return
	 */
    public ArrayList<String> getVariables() {
        return variables;
    }

    /**
	 * Regresa el string que define la funcion
     * @return
	 */
    public String getFuncion() {
        return funcion;
    }

    /**
	 * Establece la funcion
     * @param funcion string que define la funcion
	 */
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    /**
	 * Establece los nombres de las variables de la funcion
     * @param variables el arraylist con los nombre de las variables
	 */
    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }
    
}