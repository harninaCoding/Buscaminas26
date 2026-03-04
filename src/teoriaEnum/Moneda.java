package teoriaEnum;

public enum Moneda {
	EURO(1.10), DOLAR(1.0);

	private double valorEnDolares;

// Constructor (siempre privado)    
	Moneda(double valor) {
		this.valorEnDolares = valor;
	}

	public double getValor() {
		return valorEnDolares;
	}
}
