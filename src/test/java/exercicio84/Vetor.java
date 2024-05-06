package exercicio84;

import java.util.ArrayList;
import java.util.List;

public class Vetor {

    private Leitor leitor;
    private Impressora impressora;

    public Vetor(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        int tamanhoArray = leitor.ler();
        List<Integer> vetorA = new ArrayList<>(tamanhoArray);
        List<Integer> vetorB = new ArrayList<>(tamanhoArray);
        List<Integer> vetorSoma = new ArrayList<>(tamanhoArray);

        for (int i = 0; i < tamanhoArray; i++) {
            vetorA.add(leitor.ler());
        }
        for (int i = 0; i < tamanhoArray; i++) {
            vetorB.add(leitor.ler());
        }
        for (int i = 0; i < tamanhoArray; i++) {
            vetorSoma.add(vetorA.get(i) + vetorB.get(i));
        }
        impressora.imprimir(vetorA);
        impressora.imprimir(vetorB);
        impressora.imprimir(vetorSoma);
    }
}
