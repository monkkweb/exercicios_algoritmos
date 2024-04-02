package exercicio51;

public class Numeros {
    public String numerosDecrescentes() {
        StringBuilder numerosImpressos = new StringBuilder();
        for (int i = 10; i >= 1; i--) {

            numerosImpressos.append(i);
        }
        return numerosImpressos.toString();
    }
}
