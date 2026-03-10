package test.hu1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import modelo.Constructor;
import modelo.Coordenada;
import modelo.Tablero;
import test.Visor;

class TableroMinasAlrededorTest {

	@ParameterizedTest
	@MethodSource("dameCasos")
	@DisplayName("Test de adyacencia bÃ¡sica con 2 bombas (0,0 y 1,1)")
	void testCuentaMinasParam(TestData data) {
		Coordenada coordenada = new Coordenada(1, 1);
		Coordenada coordenadaDos = new Coordenada(0, 0);
		Tablero tablero = new Tablero(Constructor.TEST, coordenada, coordenadaDos);
		new Visor().visorMinasalrededor(tablero);
		int actual = tablero.getMinasAlrededor(data.casillaSinMina);
		assertEquals(data.minasAlrededorEsperado, actual,
				"Error en (" + data.casillaSinMina.getX() + "," + data.casillaSinMina.getY() + ")");
	}

	static Stream<TestData> dameCasos() {
		return Stream.of(
				new TestData(0, 1, 2), // Adyacente a (1,1) y (0,0)
				new TestData(1, 0, 2), // Adyacente a (1,1) y (0,0)
				new TestData(2, 2, 1), // Solo adyacente a (1,1)
				new TestData(4, 4, 0) // Lejos de las bombas
		);
	}

	@Test
	@DisplayName("Test de maximo numero de bombas (8 bombas alrededor)")
	void testOchoBombasAlrededor() {
		// Rodeamos la casilla (1,1)
		Coordenada[] minas = {
				new Coordenada(0, 0), new Coordenada(0, 1), new Coordenada(0, 2),
				new Coordenada(1, 0), new Coordenada(1, 2),
				new Coordenada(2, 0), new Coordenada(2, 1), new Coordenada(2, 2)
		};
		Tablero tablero = new Tablero(Constructor.TEST, minas);
		new Visor().visorMinasalrededor(tablero);
		assertEquals(8, tablero.getMinasAlrededor(new Coordenada(1, 1)));
	}

	@Test
	@DisplayName("Test de limites: Esquina (0,0) con bomba")
	void testEsquinaConBomba() {
		Coordenada mina = new Coordenada(0, 0);
		Tablero tablero = new Tablero(Constructor.TEST, mina);
		new Visor().visorMinasalrededor(tablero);
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(0, 1)));
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(1, 0)));
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(1, 1)));
		assertEquals(0, tablero.getMinasAlrededor(new Coordenada(0, 2)));
	}

	@Test
	@DisplayName("Test de limites: Borde (0,2) con bomba")
	void testBordeConBomba() {
		Coordenada mina = new Coordenada(0, 2);
		Tablero tablero = new Tablero(Constructor.TEST, mina);
		new Visor().visorMinasalrededor(tablero);
		// Adyacentes: (0,1), (0,3), (1,1), (1,2), (1,3)
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(0, 1)));
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(0, 3)));
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(1, 1)));
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(1, 2)));
		assertEquals(1, tablero.getMinasAlrededor(new Coordenada(1, 3)));
	}

	static class TestData {
		Coordenada casillaSinMina;
		int minasAlrededorEsperado;

		TestData(int x, int y, int esperado) {
			this.casillaSinMina = new Coordenada(x, y);
			this.minasAlrededorEsperado = esperado;
		}
	}

}
