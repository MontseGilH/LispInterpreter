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
}


