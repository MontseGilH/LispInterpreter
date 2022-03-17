/**
 * Ultima modificacion: 7/03/2022
 * 
 * Clase que crea una funcion
 * @file Funcion.java
 */

public class Funcion {
    private String variable;
    private String funcion;

    Funcion(String var,String fun){
        variable = var;
        funcion =fun;
    }

    public String getVariable() {
        return variable;
    }
    public String getFuncion() {
        return funcion;
    }
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    public void setVariable(String variable) {
        this.variable = variable;
    }
    
    
}
