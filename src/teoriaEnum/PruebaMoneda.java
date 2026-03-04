package teoriaEnum;

public class PruebaMoneda {
public static void main(String[] args) {
	Moneda moneda=Moneda.EURO;
	float valorEnEuros=123;
	float valorEnDolares=(float) (valorEnEuros*moneda.getValor());
	System.out.println(valorEnDolares);
}
}
