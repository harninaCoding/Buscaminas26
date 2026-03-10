package test.hu1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.Dificultad;
import presentador.EventGUI;
import vista.GUI;

class EventGUIHU1Test {

	@Test
	void test() {
		GUI gui=new GUI();
		EventGUI eventGUI=new EventGUI(gui);
		//Me deberia crear un tablero
		//TEngo un problema cuando se crea el eventgui no se crea el tablero
		//se crea cuando se dispara el evento de btniniciar
		eventGUI.crearTablero();
		gui.getCmbDificultad().setSelectedIndex(0);
		assertEquals(eventGUI.getTablero().getDificultad(),
				(Dificultad)gui.getCmbDificultad().getSelectedItem());
	}

}
