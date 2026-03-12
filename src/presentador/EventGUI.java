package presentador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.Tablero;
import vista.AccesoGUI;
import vista.MyButton;

public class EventGUI {
	private AccesoGUI gui;
	private Tablero tablero;

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

	public void crearTablero() {
		Dificultad dificultad = (Dificultad) gui.getCmbDificultad().getSelectedItem();
		tablero = new Tablero(dificultad, (Densidad) gui.getCmbDensidad().getSelectedItem());
		gui.crearBotonera(dificultad.getSize());
		configurarBotonera();
	}

	private void configurarBotonera() {
		List<Component> botones = gui.getBotones();
		for (Component boton : botones) {
			((MyButton) boton).addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					//El objeto que ha disparado el evento que me hace estar dentro de la
					//ejecucion de este metodo es el source de e.
					//este source podraia ser un jlabel, un jXXX, en nuestro caso en un MyButton.
					//cuando le digo getSource obtengo el objeto concreto y puedo hacer downcast para
					//acceder alas propiedades de esa clase.
					MyButton boton=(MyButton)e.getSource();
					//boton izquierda
					if (e.getButton() == 1) {
						// Esto es lo que eventgui GUI-->Tablero
						if (tablero.desvelarCasilla(boton.getCoordenada())) {
							// Comunicar Tablero --> GUI
							mostrarTableroActualizado(botones);
						}
						
					}else //boton derecho
						if(e.getButton() == 3) {
						
					}
				}

			});
		}
	}

	private void mostrarTableroActualizado(List<Component> botones) {
		for (Component boton : botones) {
			MyButton miBoton = ((MyButton) boton);
			Coordenada coordenada = miBoton.getCoordenada();
			if (!tablero.isVelada(coordenada)) {
				int minasAlrededor = tablero.getMinasAlrededor(coordenada);
				String minas = String.valueOf(minasAlrededor);
				if (minasAlrededor == 0)
					minas = "";
				if (tablero.isMina(coordenada))
					minas = "M";
				miBoton.setText(minas);
				miBoton.setEnabled(false);
			}
		}
	}
}
