/**
 * Ultima modificacion: 7/03/2022
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
	 * Regresa la data
	 */
    public String getDataTot(){
        return dataTot;
    }

    /**
	 * Establece la data
	 */
    public void setDataTot(String s){
        this.dataTot = s;
    }

	/**
	 * Regresa la lista
	 */
    public ArrayList<Node> getLista(){
        return lista;
    }

	/**
	 * Establece la lista
	 */
    public void setLista(ArrayList<Node> l){
        this.lista = l;
    }

	/**
	 * Inicia un nodo principal
	 */
    public Node(){
        lista = new ArrayList<Node>();
    }

	/**
	 * Regresa el tipo
	 */
    public abstract int type();

    
}
