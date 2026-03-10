package test.hu1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;

class TableroTest3 {

	static Stream<Arguments> proveerConfiguracionesTablero() {
		return Stream.of(
				Arguments.of(Dificultad.FACIL, Densidad.FACIL, 2),
				Arguments.of(Dificultad.NORMAL, Densidad.FACIL, 6),
				Arguments.of(Dificultad.DIFICIL, Densidad.FACIL, 14));
	}

	@ParameterizedTest
	@MethodSource("proveerConfiguracionesTablero")
	void test(Dificultad dificultad, Densidad densidad, int esperado) {
		Tablero tablero = new Tablero(dificultad, densidad);
		int actual = tablero.cuentaMinas();
		// comprobacion del caso de prueba
		assertEquals(esperado, actual);
	}

}
