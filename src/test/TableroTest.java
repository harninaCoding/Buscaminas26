package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;

class TableroTest {

	@Test
	void test() {
		Tablero tablero = new Tablero(Dificultad.FACIL, Densidad.FACIL);
		// 5*5 25 casillas. 25*10%= 2.5 minas. redondeamos a 2 o a 3, tu decides
		// Cuantas minas se han puesto despues de inicializar el tablero?
	}

	// no se debe hacer. porque podemos equivocarnos en este codigo.
	// tablero deberia tener un metodo cuentaMinas
	private int cuentaMinas(Casilla[][] casillas) {
		int contador = 0;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isMina())
					contador++;
			}
		}
		return contador;
	}
}
