# LispInterpreter
Interprete de lenguaje Lisp, creado en java 
Proyecto 1. Algoritmos y Estructura de Datos

La notación se escribe dejando un espacio entre cada elemento de la expresión. Por ejemplo:
( accion a b )

Este programa trabaja con float, por lo que si una expresion tiene un condicional, se necesita poner el numero y el .0 al final para que si se tome correctamente. Por ejemplo:
( cond ( ( = n 0.0 ) ( + 2 3 ) ) )

Funciones a probar:
temperatura --> ( defun FTOC ( TEMP ) ( / ( - TEMP 32 ) 1.8 ) )
fibonacci --> ( defun FIBONACCI ( n ) ( cond  ( ( = n 0.0 ) 0.0 )   ( ( = n 1.0 ) 1.0 )    ( T ( + ( FIBONACCI ( - n 1.0 ) ) ( FIBONACCI ( - n 2.0 ) ) ) ) ) )
