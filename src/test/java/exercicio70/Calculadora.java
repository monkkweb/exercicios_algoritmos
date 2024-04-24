package exercicio70;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        int maiorValor = 0;
        int valor;
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            valor = leitor.ler();
            numeros.add(valor);
        }

        int menorValor = numeros.get(0);
        for (int numeroAtual : numeros) {
            menorValor = numeroAtual < menorValor ? numeroAtual : menorValor;
        }
        for (int numeroAtual : numeros) {
            maiorValor = numeroAtual > maiorValor ? numeroAtual : maiorValor;
        }
        impressora.imprimir(maiorValor);
        impressora.imprimir(menorValor);
    }
}
//        if (!numeros.isEmpty()) {
//            menorValor = numeros.stream().min(Integer::compareTo).orElse(null);
//            maiorValor = numeros.stream().max(Integer::compareTo).orElse(null);
//        }