package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;

class TableroTest2 {

	@Test
	void test() {
		// 5*5 25 casillas. 25*10%= 2.5 minas. redondeamos a 2 o a 3, tu decides
		// Cuantas minas se han puesto despues de inicializar el tablero?
		//condiciones del caso del prueba
		int expected=2;
		//ejecucion del caso de prueba
		Tablero tablero = new Tablero(Dificultad.FACIL, Densidad.FACIL);
		int actual = tablero.cuentaMinas();
		//comprobacion del caso de prueba
		assertEquals(expected,actual);
		 expected=5;
		//ejecucion del caso de prueba
		 tablero = new Tablero(Dificultad.FACIL, Densidad.DIFICIL);
		 actual = tablero.cuentaMinas();
		//comprobacion del caso de prueba
		assertEquals(expected,actual);
	}

	
}
