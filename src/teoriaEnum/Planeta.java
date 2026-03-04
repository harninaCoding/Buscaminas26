package teoriaEnum;

public enum Planeta {
	MERCURIO(3.303e+23, 2.4397e6), TIERRA(5.976e+24, 6.37814e6), MARTE(6.421e+23, 3.3972e6);

	private final double masa; // en kilogramos
	private final double radio; // en metros
	// El constructor guarda los datos de cada planeta

	Planeta(double masa, double radio) {
		this.masa = masa;
		this.radio = radio;
	}// Constante de gravitación universal

	public static final double G = 6.67300E-11;

	public double gravedadSuperficial() {
		return G * masa / (radio * radio);
	}
}
