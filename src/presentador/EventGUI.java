package presentador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Constructor;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;
import vista.AccesoGUI;

public class EventGUI {
	private AccesoGUI gui;
	private Tablero tablero;
	//Cosntructor para pruebas
	public EventGUI(Constructor tipo,AccesoGUI gui) {
		//En este caso no es buena practica, no hay que inventar ningun metodo
	}
	public EventGUI(AccesoGUI gui) {
		super();
		this.gui = gui;
		this.gui.getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearTablero();
			}
		});
		
	}
	public Tablero getTablero() {
		return tablero;
	}
	public  void crearTablero() {
		tablero=new Tablero(
				(Dificultad) gui.getCmbDificultad()
						.getSelectedItem(),
				(Densidad) gui.getCmbDensidad().getSelectedItem());
	}
	
}
