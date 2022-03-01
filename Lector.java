import java.util.ArrayList;

/**
 * Ultima modificacion: 1/03/2022
 * 
 * Clase que interpreta un string en listas
 * @file Lector.java
 */


public class Lector {
    public ArrayList<String> stringArray(String s) throws Exception{
        ArrayList<String> operacionEnLista = new ArrayList<String>();

        // verificar que el string sea un enunciado y este en notacion lisp
        if (s == null || s.length() == 0){
            throw new Exception("error - enunciado vacio");
        } else if (s.length()<= 4){
            throw new Exception("error - enunciado muy corto");
        } else {
            if (!String.valueOf(s.charAt(0)).equals("(")){
                throw new Exception("error - enunciado no inicia con parentesis, notacion lisp");
            } else if (!String.valueOf(s.charAt(s.length()-1)).equals(")")){
                throw new Exception("error - enunciado no finaliza con parentesis, notacion lisp");
            }
        }

        //revisar cuantos parentesis hay y su lugar
        String[] caracteres = s.split("");
        ArrayList<Integer> indexInicioParentesis = new ArrayList<Integer>();
        ArrayList<Integer> indexFinalParentesis = new ArrayList<Integer>();
        int i = 0; //lleva el conteo de el indice del parentesis

        for (String f:caracteres){
            if (f.equals("(")){
                indexInicioParentesis.add(i);
            } else if (f.equals(")")){
                indexFinalParentesis.add(i);
            }
            i++;
        }




        return operacionEnLista;
    }

    public String stringA(String s){
        String[] caracteres = s.split("");
        int i = 0; //lleva el conteo de el indice del parentesis
        int indiceInicial;
        for (String f:caracteres){
            if (f.equals("(")){
                indiceInicial = i;

            } 
            i++;
        }
        return null;


        
    }
}
