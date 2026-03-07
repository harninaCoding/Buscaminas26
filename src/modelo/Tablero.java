package modelo;

import utiles.Utiles;

public class Tablero {
	private Dificultad dificultad;
	private Densidad densidad;
	private Casilla[][] casillas;

	// Cuando una clase control X, quiera crear el tablero
	public Tablero(Dificultad dificultad, Densidad densidad) {
		super();
		this.dificultad = dificultad;
		this.densidad = densidad;
		crearCasillas();
		sortearMinas();
	}

	public Tablero(Constructor tipo,Coordenada... coordena) {
		super();
		this.dificultad = Dificultad.FACIL;
		crearCasillas();
		for (Coordenada coordenada : coordena) {
			setMina(coordenada);
			establecerMinasAlrededor(coordenada);
		}
		
	}

	
	////////////////////// Establecer minas alrededor
	/**
	 * Establece en las casillas adyacente a coordenada una mina mas
	 * de las ya existentes en la casilla
	 * @param coordenada
	 */
	private void establecerMinasAlrededor(Coordenada coordenada) {

	}

	///////////////////////////////////
///////////////// Sortear minas
	// Por que hay algo de logica en la clase de Modelo?. Porque es logica que sirve
	// para para el dominio.
	// En este caso lo que hacemos es construir el dominio del problema (un tablero
	// con un monton de minas por ahi)
	// Que no estaría aqui?
	private void sortearMinas() {
		int cantidadCasillas = getTotalCasillas(getCasillas());
		int totalMinas = getTotalMinas(cantidadCasillas, getDensidad());
		for (int i = 0; i < totalMinas; i++) {
			boolean mina;
			do {
				Coordenada coordenada = sortearPosicion(getDificultad().getSize());
				mina = isMina(coordenada);
				if (!mina) {
					setMina(coordenada);
					establecerMinasAlrededor(coordenada);
				}
			} while (mina);
		}
	}

	private Coordenada sortearPosicion(int size) {
		return new Coordenada(Utiles.dameNumero(size), Utiles.dameNumero(size));
	}

	private int getTotalMinas(int cantidadCasillas, Densidad densidad) {
//		return cantidadCasillas / densidad.getPorcentaje();
		return (cantidadCasillas * densidad.getPorcentaje()) / 100;
	}

	private int getTotalCasillas(Casilla[][] casillas) {
		return casillas.length * casillas[0].length;
	}

	////////////////////////////////////////// FIN Sortear minas
	////// Crear casillas
	private void crearCasillas() {
		// aqui creo la matriz
		casillas = new Casilla[dificultad.getSize()][dificultad.getSize()];
		// aqui creo las casillas que hay dentro de la matriz
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public Densidad getDensidad() {
		return densidad;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public boolean isMina(Coordenada coordenada) {
		return casillas[coordenada.getX()][coordenada.getY()].isMina();
	}

	public void setMina(Coordenada coordenada) {
		casillas[coordenada.getX()][coordenada.getY()].setMina(true);
	}

	public int cuentaMinas() {
		int contador = 0;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isMina())
					contador++;
			}
		}
		return contador;
	}

	public int getMinasAlrededorCasilla(Coordenada coordenada) {
		return casillas[coordenada.getX()][coordenada.getY()].getMinasAlrededor();
	}

	public int cuentaMinasAlrededor(Coordenada coordenada) {
		// TODO Auto-generated method stub
		return 0;
	}

}
