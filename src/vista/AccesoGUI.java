package vista;

import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

public interface AccesoGUI {
	public JComboBox getCmbDificultad();

	public JComboBox getCmbDensidad();

	public JButton getBtnIniciar();

	public void crearBotonera(int dimension);
	
	public List<Component> getBotones();
}
