/**
 * Ultima modificacion: 1/03/2022
 * 
 * Clase que test del interprete, para corregir errores
 * @file ClaseTest.java
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClaseTest {
    
	
	/**
	 * Evalua el metodo de validar sintaxis de una funcion
	 */
	@Test
	void testRevisarExpresion()  {
		Lector l = new Lector();
		assertEquals(true,l.revisaExpresion("( + 2 3 )"));
		assertEquals(true,l.revisaExpresion("( + 2 3 ( ) ( ) ( ) ( + 3 4 3 ) )"));
		assertEquals(false,l.revisaExpresion("( + 2 ) 3 ) "));
		assertEquals(false,l.revisaExpresion("+ 2 ( 3 ) "));
		assertEquals(false,l.revisaExpresion(" ( + 2 ) 3"));
		assertEquals(false,l.revisaExpresion(" "));
	}
	
	/**
	 * Evalua el metodo para evaluar un nodo suma
	 */
	@Test
	void testEvaluarSuma()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( + 2 3 )");
			assertEquals("5.0",nodo.getNodeEvaluated().getDataTot());
			Node nodo2 = l.stringANode("( + 2 3 3 4 5 6 12 )");
			assertEquals("35.0",nodo2.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua el metodo para evaluar un nodo resta
	 */
	@Test
	void testEvaluarResta()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( - 2 3 )");
			assertEquals("-1.0",nodo.getNodeEvaluated().getDataTot());
			Node nodo2 = l.stringANode("( - 2 3 3 4 5 6 12 )");
			assertEquals("-31.0",nodo2.getNodeEvaluated().getDataTot());
			Node nodo3 = l.stringANode("( - 12 3 )");
			assertEquals("9.0",nodo3.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua el metodo para evaluar un nodo multiplicacion
	 */
	@Test
	void testEvaluarMultiplicacion()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( * 2 3 )");
			assertEquals("6.0",nodo.getNodeEvaluated().getDataTot());
			Node nodo2 = l.stringANode("( * 2 3 3 4 5 6 12 )");
			assertEquals("25920.0",nodo2.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua el metodo para evaluar un nodo division
	 */
	@Test
	void testEvaluarDivision()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( / 6 2 )");
			assertEquals("3.0",nodo.getNodeEvaluated().getDataTot());
			Node nodo2 = l.stringANode("( / 2 4 )");
			assertEquals("0.0",nodo2.getNodeEvaluated().getDataTot());
			Node nodo3 = l.stringANode("( / 85 5 )");
			assertEquals("17.0",nodo3.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	
}


