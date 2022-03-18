import java.util.ArrayList;

//import java.util.ArrayList;


/**
 * Ultima modificacion: 1/07/2022
 * 
 * Clase que interpreta un string en listas
 * @file Lector.java
 */


public class Lector {




	/**
	 * Pasa una expresion a un conjunto de nodos
     * @param String
     * @return Node
	 */
    public Node stringANode(String s) throws Exception{
        //creamos el arraylist de nodos
        ArrayList<Node> array = new ArrayList<Node>();

        

        if (s == null || s.length() == 0){
        	throw new Exception(" - no se cumple con la escritura adecuada");
         }
         if (!Character.toString(s.charAt(0)).equals("(")){
        	 throw new Exception(" - no se cumple con la escritura adecuada");
         }
         if (!Character.toString(s.charAt(1)).equals(" ")){
        	 throw new Exception(" - no se cumple con la escritura adecuada");
         }
         if (!Character.toString(s.charAt(s.length()-1)).equals(")")){
        	 throw new Exception(" - no se cumple con la escritura adecuada");
         }
         if (!Character.toString(s.charAt(s.length()-2)).equals(" ")){
        	 throw new Exception(" - no se cumple con la escritura adecuada");
         }
        
       //revisar cuantos parentesis hay 
         String[] caracteres = s.split("");
         int inicioP = 0; //lleva el conteo de inicio de parentesis
         int finalP = 0; //lleva el conteo de final de parentesis

         for (String f:caracteres){
             if (f.equals("(")){
                 inicioP ++;
             } else if (f.equals(")")){
                 finalP++;
             }
         }
         
         if (!(inicioP==finalP)) {
        	 throw new Exception(" - no se cumple con la escritura adecuada");
         }
        
        
        //la expresion  es la base, por lo que quitamos el parentesis inicial y final
        //de igual manera se quitan los espacios que deberian ir
        s = s.substring(2,s.length()-2);

        //separamos la expresion por los espacios
        String[] listaS = s.split(" ");

        //variable para controlar los parentesis
        int parenA = 0;
        //conteo de el indice por el que vamos
        int num = 0;
        //conteo de donde empieza una expresion
        int start = 0;

        for (String sL : listaS){
            //llevar conteo de los parentesis adentro de la expresion
            int parenD = 0;
            if (sL.equals("(")){
                parenA +=1;
                parenD +=1;
                if (parenA==parenD){
                    start = num;
                }
            } else if (sL.equals(")" )){
                parenA -=1;
                if (parenA == 0){
                    //se toma la expresion llevada
                    String ex = "";
                    for (int i=start;i<num;i++){
                        ex += listaS[i];
                        ex += " ";
                    }
                    ex += ")";
                    array.add(stringANode(ex));     
                }
            } else if (parenA==0){
                array.add(new Valor(sL));
            }
            num +=1;

        }
        return new Expresion(array);
    }

}
