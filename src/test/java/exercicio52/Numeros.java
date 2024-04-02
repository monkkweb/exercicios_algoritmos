package exercicio52;

public class Numeros {

    public String numerosInteiros() {
        StringBuilder numerosImpressos = new StringBuilder();
        for (int numero = 101; numero <= 110; numero++) {

            numerosImpressos.append(numero);
        }
        return numerosImpressos.toString();
    }
}
