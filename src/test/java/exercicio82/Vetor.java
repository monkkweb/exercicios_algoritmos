package exercicio82;

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
        List<Double> vetorA = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Double numero = leitor.ler();
            vetorA.add(numero);
        }
        var multiplicador = leitor.ler();
        List<Double> vetorM = new ArrayList<>(10);
        for (double numerosDoVetorA : vetorA) {
            vetorM.add(numerosDoVetorA * multiplicador);
        }
        impressora.imprimir(vetorM);
        System.out.println(vetorM);

    }
}
