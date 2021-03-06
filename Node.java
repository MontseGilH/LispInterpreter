/**
 * Ultima modificacion: 18/03/2022
 * 
 * Clase que crea un Nodo
 * @file Node.java
 */
import java.util.ArrayList;

public abstract class Node {
    //protected float dataF;
    //protected String dataS;
    //protected boolean dataB;
    protected String dataTot;
    protected ArrayList<Node> lista;
    protected int tipo; //boolean = 0, float 1, string 2, lista 3

	/**
	 * Regresa el tipo
     * @return
	 */
    public abstract int type();
    
    /**
	 * Establece la data
     * @param s string con la data
	 */
    public void setDataTot(String s){
        this.dataTot = s;
    }

	/**
	 * Regresa la lista
     * @return
	 */
    public ArrayList<Node> getLista(){
        return lista;
    }

	/**
	 * Establece la lista
     * @param l lista con los nodos
	 */
    public void setLista(ArrayList<Node> l){
        this.lista = l;
    }
    
	/**
	 * Regresa la data del nodo
     * @return
	 */
    public String getDataTot(){
        return dataTot;
    }

	/**
	 * Regresa el nodo con la data ya evaluada
     * @return
	 */
    public Node getNodeEvaluated(){
        if (tipo==3){
            //es una expresion
            //obtener el primer valor 
            String first = lista.get(0).getDataTot();

            //OPERACIONES ARIMTETICAS + - * /
            if (first.equalsIgnoreCase("+")){
                //suma
                float suma = 0;
                //se quita la palabra suma
                lista.remove(0);
                //se suman todos los elementos adentro de la lista
                for (int i = 0;i<lista.size();i++){
                    float valor = Float.parseFloat(lista.get(i).getNodeEvaluated().getDataTot());
                    suma +=valor;
                }
                return new Valor(suma);
            } else if (first.equalsIgnoreCase("-")) {
                //resta
                //se quita la palabra resta
                lista.remove(0);
                //se toma el primer numero
                float resta = Float.parseFloat(lista.get(0).getNodeEvaluated().getDataTot());
                // se restan todos los siguientes numeros a el primer numero de la lista
                for (int i = 1;i<lista.size();i++){
                    float valor = Float.parseFloat(lista.get(i).getNodeEvaluated().getDataTot());
                    resta -=valor;
                }
                return new Valor(resta);
            } else if (first.equalsIgnoreCase("*")) {
                //multiplicacion
                float multiplicacion = 1;
                //se quita la palabra multiplicacion
                lista.remove(0);
                //se multiplican todos los numeros dentro de la lista
                for (int i = 0;i<lista.size();i++){
                    float valor = Float.parseFloat(lista.get(i).getNodeEvaluated().getDataTot());
                    multiplicacion *=valor;
                }
                return new Valor(multiplicacion);
            } else if (first.equalsIgnoreCase("/")) {
                //division
                //se quita la palabra division
                lista.remove(0);
                //se toma el primer numero de la lista
                float division = Float.parseFloat(lista.get(0).getNodeEvaluated().getDataTot());
                //el primer numero se divide dentro de todos los numeros en la lista
                for (int i = 1;i<lista.size();i++){
                    float valor = Float.parseFloat(lista.get(i).getNodeEvaluated().getDataTot());
                    division /=valor;
                }
                return new Valor(division);
            
            // INSTRUCCION QUOTE
            } else if (first.equalsIgnoreCase("'")||first.equalsIgnoreCase("QUOTE")) {
                //regresa el valor de la expresion sin evaluar
                //se quita la palabra quote
                lista.remove(0);
                //se regresa el mismo nodo
                return new Expresion(lista);

            // DEFINICION FUNCIONES
            } else if (first.equalsIgnoreCase("DEFUN")) {
            	//agrega una funcion con su nombre a la lista de funciones
                //obtener el nombre
                String nombre = lista.get(1).getDataTot();
                //obtener todas las variables
                ArrayList<String> variables = new ArrayList<String>();
                for (Node e : lista.get(2).getLista()){
                    variables.add(e.getDataTot());
                }
                //Obtener el string que define la funcion
                String fun = lista.get(3).getDataTot();
                //agregar funcion al almacen
                AlmacenFunYVar.addFuncion(nombre, new Funcion(variables,fun));
                return new Valor(true);

            //revisar si es el nombre de una funcion
            } else if (AlmacenFunYVar.getFunciones().containsKey(first)) {
            	ArrayList<String> varArray = new ArrayList<String>();
                //obtener el valor de las variables a evaluar
            	Node variable = lista.get(1).getNodeEvaluated();
            	for (Node vars: variable.getLista()) {
            		varArray.add(vars.getNodeEvaluated().getDataTot());
            	}
                //Obtener el string que definia la funcion
                String funcion = AlmacenFunYVar.getFunciones().get(first).getFuncion();
                //Obtener el nombre de las variables a reemplazar
                ArrayList<String> nomVariables = AlmacenFunYVar.getFunciones().get(first).getVariables();
                String[] l = funcion.split(" ");
                //reemplazar variable con el nuevo numero
                String f = "";
                for (String s: l) {
                    boolean agregar = true;
                    for (int i = 0;i<nomVariables.size();i++){
                        if (s.equals(nomVariables.get(i))){
                            f+=varArray.get(i);
                            f+= " ";
                            agregar = false;
                        }
                    }
                	if (agregar) {
                		f+=s;
                		f+= " ";
                	}
                }
                Lector lector = new Lector();
                //crear un nodo con la funcion y evaluar
                Node nodo = null;
                try {
                	nodo = lector.stringANode(f.substring(0,f.length()-1));
                } catch (Exception e) {
                }
                return nodo.getNodeEvaluated();

            // SETQ
            } else if (first.equalsIgnoreCase("SETQ")) {
                //agrega una variable
                String nombre =lista.get(1).getDataTot();
                Node variable =  lista.get(2).getNodeEvaluated();
                AlmacenFunYVar.addVar(nombre,variable);
                return new Valor(true);
                
            // PREDICADOS ATOM LIST EQUAL < >
            } else if (first.equalsIgnoreCase("ATOM")) {
                //revisa si es un valor o una lista
                if (lista.get(1).tipo==3){
                    return new Valor(false);
                } else {
                    return new Valor (true);
                }
            } else if (first.equalsIgnoreCase("LIST")) {
                //evaluar lista
                ArrayList<Node> nuevo = new ArrayList<Node>();
                //quitar la palabra lista
                lista.remove(0);
                for (Node expresion:lista){
                    nuevo.add(expresion.getNodeEvaluated());
                }
                return new Expresion(nuevo);
            } else if (first.equalsIgnoreCase("EQUAL")||first.equalsIgnoreCase("=")) {
                //revisa si son iguales los 2 elementos
                String n1 = lista.get(1).getNodeEvaluated().getDataTot();
                String n2 =lista.get(2).getNodeEvaluated().getDataTot();
                if(n1.equals(n2)){
                    return new Valor(true);
                } else {
                    return new Valor(false);
                }
            } else if (first.equalsIgnoreCase("<")) {
                //revisa si el segundo es mayor
                String n1 = lista.get(1).getNodeEvaluated().getDataTot();
                String n2 =lista.get(2).getNodeEvaluated().getDataTot();
                int n1num=0;
                int n2num=0;
                boolean numero = false;
                //determinar si es numero
                try {
                    n1num=Integer.valueOf(lista.get(1).getNodeEvaluated().getDataTot());
                    n2num=Integer.valueOf(lista.get(2).getNodeEvaluated().getDataTot());
                } catch (Exception e){
                    //no pasa nada
                }
                if (numero){
                    //comparar numeros
                    if (n1num<n2num){
                        return new Valor(true);
                    } else {
                        return new Valor(false);
                    }
                } else {
                    //comparar strings
                    if (n1.compareTo(n2)<0){
                        return new Valor(true);
                    } else {
                        return new Valor(false);
                    }
                }

            } else if (first.equalsIgnoreCase(">")) {
                //evalua si el primero es mayor
                String n1 = lista.get(1).getNodeEvaluated().getDataTot();
                String n2 =lista.get(2).getNodeEvaluated().getDataTot();
                int n1num=0;
                int n2num=0;
                boolean numero = false;
                //determinar si es numero
                try {
                    n1num=Integer.valueOf(lista.get(1).getNodeEvaluated().getDataTot());
                    n2num=Integer.valueOf(lista.get(2).getNodeEvaluated().getDataTot());
                } catch (Exception e){
                    //no pasa nada
                }
                if (numero){
                    //comparar numeros
                    if (n1num>n2num){
                        return new Valor(true);
                    } else {
                        return new Valor(false);
                    }
                } else {
                    //comparar strings
                    if (n1.compareTo(n2)>0){
                        return new Valor(true);
                    } else {
                        return new Valor(false);
                    }
                }
            // CONDICIONALES COND
            } else if (first.equalsIgnoreCase("COND")) {
                //revisar cada condicional, y si una es verdadera, ejecutar
                //primero quitar la palabra condicional
                lista.remove(0);
                //iterar
                for(Node nodo:lista){
                    String valorB = nodo.getLista().get(0).getNodeEvaluated().getDataTot();
                    if (valorB.equals("T")){
                        return nodo.getLista().get(1).getNodeEvaluated();
                    }
                }
                //si no se cumple nada
                return new Valor(false);

            } else {
                //evaluar lista
                ArrayList<Node> nuevo = new ArrayList<Node>();
                for (Node expresion:lista){
                    nuevo.add(expresion.getNodeEvaluated());
                }
                return new Expresion(nuevo);
            }
        } else {
            
            //tiene que ser un valor 
            //revisar si es una variable ya definida 
            if (AlmacenFunYVar.getVariables().containsKey(dataTot)){
            	String n = AlmacenFunYVar.getVariables().get(dataTot).getDataTot();
            	
                return new Valor(n);
            }
            //si no era variable solo se devuelve el mismo nodo
            return this;
        }
    }



	/**
	 * Inicia un nodo principal
     * Constructor
	 */
    public Node(){
        lista = new ArrayList<Node>();
    }



    
}
