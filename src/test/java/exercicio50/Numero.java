package exercicio50;

public class Numero {
    public String numerosCrescentes() {

        StringBuilder numerosImpressos = new StringBuilder();

        for (int i = 1; i <= 10; i++) {

            numerosImpressos.append(i);
        }
        return numerosImpressos.toString();
    }
}
