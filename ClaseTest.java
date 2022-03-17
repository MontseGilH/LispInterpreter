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
	
	/**
	 * Evalua el metodo para evaluar un nodo quote
	 */
	@Test
	void testEvaluarQuote()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("(' 6 2 2 )");
			assertEquals("( 6 2 2 )",nodo.getNodeEvaluated().getDataTot());
			Node nodo2 = l.stringANode("( ' + 4 2 )");
			assertEquals("( + 4 2 )",nodo2.getNodeEvaluated().getDataTot());
			assertEquals("6.0",nodo2.getNodeEvaluated().getDataTot());
			Node nodo3 = l.stringANode("( QUOTE 85 5 )");
			assertEquals("( 85 5 )",nodo3.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua el metodo para defun
	 */
	@Test
	void testEvaluarDefun()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( DEFUN resta ( n ) ( - n 1 ) )");
			nodo.getNodeEvaluated();
			assertEquals(true,AlmacenFunYVar.getFunciones().containsKey("resta"));
			assertEquals("n",AlmacenFunYVar.getFunciones().get("resta").getVariable());
			assertEquals("( - n 1 )",AlmacenFunYVar.getFunciones().get("resta").getFuncion());
			Node nodo2 = l.stringANode("( resta ( + 1 1 ) )");
			assertEquals(0.0,nodo2.getNodeEvaluated().dataTot);
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua el metodo para añadir variables
	 */
	@Test
	void testEvaluarSetQ()  {
		Lector l = new Lector();
		try {

			Node nodo2 = l.stringANode("( SETQ nombre2 maria2 )");
			nodo2.getNodeEvaluated();
			assertEquals(false,AlmacenFunYVar.getVariables().containsKey("maria2"));
			assertEquals(true,AlmacenFunYVar.getVariables().containsKey("nombre2"));
			//assertEquals(true,AlmacenFunYVar.getVariables().containsValue(new Valor("maria2")));
			assertEquals("maria2",AlmacenFunYVar.getVariables().get("nombre2").getNodeEvaluated().getDataTot());
			
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua el metodo para revisar si un valor es ATOM
	 */
	@Test
	void testEvaluarAtom()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( ATOM ( nombre ) ( maria ) )");
			Node nodo2 = l.stringANode("( ATOM nombre )");
			Node nodo3 = l.stringANode("( ATOM ( 2 3 3 ) )");
			assertEquals("NIL",nodo.getNodeEvaluated().getDataTot());
			assertEquals("T",nodo2.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo3.getNodeEvaluated().getDataTot());
			
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua evaluar una lista lol
	 */
	@Test
	void testEvaluarLista()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( LIST ( + 2 3 ) ( ATOM nombre ) )");
			Node nodo2 = l.stringANode("( ( * 2 3 ) ( ATOM nombre ) )");
			assertEquals("( 5.0 T )",nodo.getNodeEvaluated().getDataTot());
			assertEquals("( 6.0 T )",nodo2.getNodeEvaluated().getDataTot());
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua analizar equal
	 */
	@Test
	void testEvaluarEqual()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( EQUAL ( + 2 3 ) ( + 1 4 ) )");
			Node nodo2 = l.stringANode("( EQUAL 3 3 )");
			Node nodo3 = l.stringANode("( EQUAL 5 3 )");
			assertEquals("T",nodo.getNodeEvaluated().getDataTot());
			assertEquals("T",nodo2.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo3.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua analizar menor o mayor
	 */
	@Test
	void testEvaluarMenorOMayor()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( < 3 4 )");
			Node nodo2 = l.stringANode("( > 3 4 )");
			Node nodo3 = l.stringANode("( > 4 3 )");
			Node nodo4 = l.stringANode("( < 4 3 )");
			Node nodo5 = l.stringANode("( < hola adios )");
			Node nodo6 = l.stringANode("( > hola adios )");
			Node nodo7 = l.stringANode("( > adios hola )");
			Node nodo8 = l.stringANode("( < adios hola )");
			assertEquals("T",nodo.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo2.getNodeEvaluated().getDataTot());
			assertEquals("T",nodo3.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo4.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo5.getNodeEvaluated().getDataTot());
			assertEquals("T",nodo6.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo7.getNodeEvaluated().getDataTot());
			assertEquals("T",nodo8.getNodeEvaluated().getDataTot());
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Evalua condicional
	 */
	@Test
	void testEvaluarCond()  {
		Lector l = new Lector();
		try {
			Node nodo = l.stringANode("( COND ( ( < 2 1 ) ( + 2 3 ) ) ( ( > 2 1 ) ( + 3 3 ) ) )");
			Node nodo2 = l.stringANode("( COND ( ( ATOM ( 2 1 ) ) ( + 2 3 ) ) ( ( EQUAL 2 1 ) ( + 3 3 ) ) )");
			assertEquals("6.0",nodo.getNodeEvaluated().getDataTot());
			assertEquals("NIL",nodo2.getNodeEvaluated().getDataTot());
			
		} catch (Exception e) {
			
		}
		
	}
	
	
}


