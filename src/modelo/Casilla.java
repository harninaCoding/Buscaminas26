package modelo;

public class Casilla {
	private boolean mina;
	private int minasAlrededor;
	private boolean velada=true;
	private boolean marcada=false;

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

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
