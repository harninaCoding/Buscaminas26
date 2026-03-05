package test;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Visor {

	public void visorMinasalrededor(Tablero tablero) {
		Casilla[][] casillas = tablero.getCasillas();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				int minasAlrededor = casillas[i][j].getMinasAlrededor();
				if(tablero.isMina(new Coordenada(i,j))) minasAlrededor=9;
				System.out.print(minasAlrededor);
			}
			System.out.println();
		}
	}
}
