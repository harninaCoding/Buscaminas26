package teoriaEnum;
import static teoriaEnum.DiasSemana.*;
public class PruebaSemana {

	public static void main(String[] args) {
		DiasSemana semana=Lunes;
		//Te da los valores que hay en la enum
		DiasSemana[] values = DiasSemana.values();
		for (int i = 0; i < values.length; i++) {
			System.out.println( DiasSemana.values()[i]);
		}
		//Para obtener el valor de la enum a partir de su cadena String
		DiasSemana valueOf = DiasSemana.valueOf("Lunes");
		System.out.println(valueOf);
		//obtener el String a partir del valor de enum
		String string = valueOf.toString();
		System.out.println(string);
		//En que posicion del enum esta un valor concreto
		System.out.println(DiasSemana.Lunes.ordinal());
	}

}
