package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Constructor;
import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;

class TableroMinasAlrededor {

	@Test
	@Disabled
	@DisplayName("probando que las casillas se rellenas correctamente, con minas alrededor")
	void test() {
		// Si yo creo un tablero. al final de la construccion tienen que estar bien
		// definidas
		// las minas alrededor de cada casilla
		Dificultad facil = Dificultad.FACIL;
		Tablero tablero = new Tablero(facil, Densidad.FACIL);
		int contador = 0;
		// Ante una situacion aleatoria
		for (int i = 0; i < facil.getSize(); i++) {
			for (int j = 0; j < facil.getSize(); j++) {
				Coordenada coordenada=new Coordenada(i, j);
				//Este resultado te dice las minas que hay segun establecerMinasAlrededor
				int actual = tablero.getMinasAlrededorCasilla(coordenada);
				//Este metodo esta hecho solo para poder comprobar que funciona el anterior.
				//recorrer las casillas adyacente a la coordenada para conocer el numero
				//de minas alrededor
				//Esto ensucia el codigo. Ya lo hicimos con el metodo.cuentaMinas. No debemos abusar
				//el problema es que puedes equivocarte en los dos metodos
				int expected=tablero.cuentaMinasAlrededor(coordenada);
				assertEquals(expected, actual);
				/*
				 * Me veo obigado a esto porque es aleatorio. 
				//otra posible solucion es un constructor de pruebas. donde puedo 
				 * crear un objeto donde desaparece la aleatoriedad.
				 */
			}
		}
	}
	
	@Test
	void testNoAleatorio() {
		Coordenada coordenada = new Coordenada(1,1);
		Coordenada adyacente = new Coordenada(0,0);
		Tablero tablero=new Tablero(Constructor.TEST, coordenada);
		int expected=1;
		new Visor().visorMinasalrededor(tablero);
		int actual = tablero.getMinasAlrededorCasilla(adyacente);
		assertEquals(expected, actual);
	}
	@Test
	void testCuentaMinasDos() {
		Coordenada coordenadaMinaUno = new Coordenada(1,1);
		Coordenada coordenadaMinaDos= new Coordenada(0,0);		
		Coordenada casillaAdyacenteAMinas = new Coordenada(0,1);		
		Tablero tablero=new Tablero(Constructor.TEST, coordenadaMinaUno,coordenadaMinaDos);
		new Visor().visorMinasalrededor(tablero);
		int expected=2;
		int actual = tablero.cuentaMinasAlrededor(casillaAdyacenteAMinas);
		assertEquals(expected, actual);
		casillaAdyacenteAMinas = new Coordenada(1,0);		
		actual = tablero.cuentaMinasAlrededor(casillaAdyacenteAMinas);
		assertEquals(expected, actual);
	}

}
