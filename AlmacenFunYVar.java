/**
 * Ultima modificacion: 1/03/2022
 * 
 * Clase que almacena funciones y variables definidas anteriormente
 * @file AlmacenFunYVar.java
 */
import java.util.ArrayList;
import java.util.HashMap;

public class AlmacenFunYVar {
    private HashMap<String, Node> variables = new HashMap<String,Node>();
    private HashMap<String, Funcion> funciones = new HashMap<String,Funcion>();

    /**
	 * Regresa la data
	 */
    public HashMap<String, Funcion> getFunciones() {
        return funciones;
    }
    public HashMap<String, Node> getVariables() {
        return variables;
    }
    public void setVariables(HashMap<String, Node> variables) {
        this.variables = variables;
    }
    public void setFunciones(HashMap<String, Funcion> funciones) {
        this.funciones = funciones;
    }
}
