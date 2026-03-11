package vista;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import modelo.Coordenada;

public class Botonera extends JPanel {

	public Botonera(int dimension) {
		super();
		setLayout(new GridLayout(dimension, dimension, 0, 0));
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				MyButton comp = new MyButton(new Coordenada(i, j));
				add(comp);
			}
		}
	}

	public Component getElemento(Coordenada coordenada) {
		for (Component boton : getComponents()) {
			if (((MyButton) boton).getCoordenada().equals(coordenada))
				return boton;
		}
		return null;
	}

}
