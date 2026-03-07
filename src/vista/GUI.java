package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Densidad;
import modelo.Dificultad;

public class GUI extends JFrame implements AccesoGUI{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cmbDificultad;
	private JComboBox cmbDensidad;
	private JButton btnIniciar;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSur = new JPanel();
		contentPane.add(pnlSur, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSur = new GridBagLayout();
		gbl_pnlSur.columnWidths = new int[] {101, 201, 101, 201, 201, 30, 30, 30, 0};
		gbl_pnlSur.rowHeights = new int[]{21, 0};
		gbl_pnlSur.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSur.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSur.setLayout(gbl_pnlSur);
		
		JLabel lblNewLabel = new JLabel("Dificultad");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		pnlSur.add(lblNewLabel, gbc_lblNewLabel);
		
		cmbDificultad = new JComboBox();
		GridBagConstraints gbc_cmbDificultad = new GridBagConstraints();
		gbc_cmbDificultad.fill = GridBagConstraints.BOTH;
		gbc_cmbDificultad.insets = new Insets(0, 0, 0, 5);
		gbc_cmbDificultad.gridx = 1;
		gbc_cmbDificultad.gridy = 0;
		pnlSur.add(cmbDificultad, gbc_cmbDificultad);
		
		JLabel lblNewLabel_1 = new JLabel("Densidad");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		pnlSur.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cmbDensidad = new JComboBox();
		GridBagConstraints gbc_cmbDensidad = new GridBagConstraints();
		gbc_cmbDensidad.fill = GridBagConstraints.BOTH;
		gbc_cmbDensidad.insets = new Insets(0, 0, 0, 5);
		gbc_cmbDensidad.gridx = 3;
		gbc_cmbDensidad.gridy = 0;
		pnlSur.add(cmbDensidad, gbc_cmbDensidad);
		
		btnIniciar = new JButton("Inciar");
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.gridwidth = 3;
		gbc_btnIniciar.fill = GridBagConstraints.BOTH;
		gbc_btnIniciar.gridx = 5;
		gbc_btnIniciar.gridy = 0;
		pnlSur.add(btnIniciar, gbc_btnIniciar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		//configurando el cmb de Dificultad 
		getCmbDificultad().setModel(new DefaultComboBoxModel(Dificultad.values()));
		getCmbDificultad().setSelectedIndex(0);
		//configurando el cmb de Densidad 
		getCmbDensidad().setModel(new DefaultComboBoxModel(Densidad.values()));
		getCmbDensidad().setSelectedIndex(0);
	}
	public JComboBox getCmbDificultad() {
		return cmbDificultad;
	}

	public JComboBox getCmbDensidad() {
		return cmbDensidad;
	}

	public JButton getBtnIniciar() {
		return btnIniciar;
	}
}
