package control;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Densidad;
import modelo.Tablero;

public class Sorteador {

	public void sortearMinas(Tablero tablero) {
		int cantidadCasillas=getTotalCasillas(tablero.getCasillas());
		int totalMinas=getTotalMinas(cantidadCasillas,tablero.getDensidad());
		for (int i = 0; i < totalMinas; i++) {
			boolean mina;
			do {
				Coordenada coordenada=sortearPosicion(tablero.getDificultad().getSize());
				mina= tablero.isMina(coordenada);
				if(!mina) {
					tablero.setMina(coordenada);
				}
			}while(mina);
		}
	}
	
	private int dameNumero(int limite) {
		return (int) (Math.random() * (limite));
	}
	
	private Coordenada sortearPosicion(int size) {
		return new Coordenada(dameNumero(size),dameNumero(size));
	}

	private int getTotalMinas(int cantidadCasillas, Densidad densidad) {
		return cantidadCasillas/densidad.getPorcentaje();
	}

	private int getTotalCasillas(Casilla[][] casillas) {
		return casillas.length*casillas[0].length;
	}
}
