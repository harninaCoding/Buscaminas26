package test.hu2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Constructor;
import modelo.Coordenada;
import modelo.Tablero;

class DesvelarCasillaTest {

    @Test
    @DisplayName("Test desvelar casilla con minas alrededor (no recursivo)")
    void testDesvelarCasillaConMinasAlrededor() {
        // Mina en (0,1)
        Coordenada mina = new Coordenada(0, 1);
        Tablero tablero = new Tablero(Constructor.TEST, mina);

        // (0,0) tiene una mina alrededor
        Coordenada seleccion = new Coordenada(0, 0);
        assertTrue(tablero.desvelarCasilla(seleccion));

        assertFalse(tablero.isVelada(seleccion), "La casilla (0,0) debería estar desvelada");
        assertTrue(tablero.isVelada(new Coordenada(1, 0)), "La casilla (1,0) no debería haberse desvelado");
        assertTrue(tablero.isVelada(new Coordenada(1, 1)), "La casilla (1,1) no debería haberse desvelado");
    }

    @Test
    @DisplayName("Test desvelar casilla libre (recursivo)")
    void testDesvelarCasillaLibreRecursivo() {
        // Barrera de minas alrededor de 0,0 a 1,1
        Coordenada[] minas = {
                new Coordenada(0, 2), new Coordenada(1, 2), new Coordenada(2, 2),
                new Coordenada(2, 1), new Coordenada(2, 0)
        };
        Tablero tablero = new Tablero(Constructor.TEST, minas);

        // (0,0) es libre (0 minas)
        Coordenada seleccion = new Coordenada(0, 0);
        assertTrue(tablero.desvelarCasilla(seleccion));

        // El area 2x2 deberia desvelarse
        assertFalse(tablero.isVelada(new Coordenada(0, 0)));
        assertFalse(tablero.isVelada(new Coordenada(0, 1)));
        assertFalse(tablero.isVelada(new Coordenada(1, 0)));
        assertFalse(tablero.isVelada(new Coordenada(1, 1)));

        // las minas no deberian desvelarse
        assertTrue(tablero.isVelada(new Coordenada(0, 2)));
        assertTrue(tablero.isVelada(new Coordenada(2, 0)));

        //las celdas fuera del tablero no deben desvelarse
        assertTrue(tablero.isVelada(new Coordenada(3, 3)));
    }

    @Test
    @DisplayName("Test desvelar mina")
    void testDesvelarMina() {
        Coordenada mina = new Coordenada(4, 4);
        Tablero tablero = new Tablero(Constructor.TEST, mina);

        assertTrue(tablero.desvelarCasilla(mina));
        assertFalse(tablero.isVelada(mina));
        assertTrue(tablero.isMina(mina));
    }

    @Test
    @DisplayName("Test desvelar casilla ya desvelada")
    void testDesvelarCasillaYaDesvelada() {
        Coordenada mina = new Coordenada(1, 1);
        Tablero tablero = new Tablero(Constructor.TEST, mina);

        Coordenada seleccion = new Coordenada(0, 0);
        assertTrue(tablero.desvelarCasilla(seleccion)); // primera vez: true
        assertFalse(tablero.desvelarCasilla(seleccion)); // segunda vez: false
    }
}
