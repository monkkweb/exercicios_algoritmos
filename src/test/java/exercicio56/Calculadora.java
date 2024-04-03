package exercicio56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void tabuada() {
        int numeroDaMultiplicacao = leitor.ler();
        List<Integer> resultado = new ArrayList<>();
        for (int numeroDaTabuada = 0; numeroDaTabuada < 10; numeroDaTabuada++) {
            resultado = Collections.singletonList(numeroDaMultiplicacao * (1 + numeroDaTabuada));
        }
        impressora.imprimir(resdo);
    }
}
