import java.util.ArrayList;

/**
 * Ultima modificacion: 17/03/2022
 * 
 * Clase que crea una funcion
 * @file Funcion.java
 */

public class Funcion {
    private ArrayList<String> variables;
    private String funcion;

    Funcion(ArrayList<String> vars,String fun){
        variables = vars;
        funcion =fun;
    }

    public ArrayList<String> getVariables() {
        return variables;
    }
    public String getFuncion() {
        return funcion;
    }
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }
    
    
}