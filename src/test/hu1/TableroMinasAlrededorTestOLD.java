package test.hu1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import modelo.Constructor;
import modelo.Coordenada;
import modelo.Tablero;
import test.Visor;

class TableroMinasAlrededorTestOLD {

	@ParameterizedTest
	@MethodSource("dameCasos")
	void testCuentaMinasParam(TestData data) {
		Coordenada coordenada = new Coordenada(1, 1);
		Coordenada coordenadaDos = new Coordenada(0, 0);
		Tablero tablero = new Tablero(Constructor.TEST, coordenada, coordenadaDos);
		new Visor().visorMinasalrededor(tablero);
		int actual = tablero.getMinasAlrededor(data.casillaSinMina);
		assertEquals(data.minasAlrededorEsperado, actual);
	}

	static Stream<TestData> dameCasos() {
		return Stream.of(
				new TestData(0, 1, 2), // Adyacente a (1,1) y (0,0)
				new TestData(1, 0, 2), // Adyacente a (1,1) y (0,0)
				new TestData(2, 2, 1), // Solo adyacente a (1,1)
				new TestData(4, 4, 0) // Lejos de las bombas
		);
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
