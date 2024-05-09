package exercicio90;


import java.util.ArrayList;
import java.util.List;

public class Vetor {
    private Leitor leitor;
    private Impressora impressora;

    public Vetor(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    public void calcular() {
        List<Integer> vetor = new ArrayList<>(30);
        int quantidadeQueOhNumeroRepetiu = 0;

        for (int i = 0; i < 30; i++) {
            vetor.add(leitor.ler());
        }
        impressora.imprimirList(vetor);

        int numeroProcurado = leitor.ler();
        for (int i = 0; i < vetor.size(); i++) {
            if (vetor.get(i) == numeroProcurado)
                quantidadeQueOhNumeroRepetiu++;
        }
        impressora.imprimirInt(quantidadeQueOhNumeroRepetiu);

    }
}
