package teoriaEnum;

public enum DiasSemana {
	Lunes(0),Martes(-1),Miercoles(2);
	
	private int animo;

	private DiasSemana(int animo) {
		this.animo = animo;
	}

	public int getAnimo() {
		return animo;
	}


	
	
}
