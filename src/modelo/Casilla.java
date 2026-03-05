package modelo;

public class Casilla {
	private boolean mina;
	private int minasAlrededor;

	public int getMinasAlrededor() {
		return minasAlrededor;
	}

	public void setMinasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}

	public Casilla() {
		super();
		this.mina = false;
		this.minasAlrededor = 0;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina=mina;
		
	}

}
