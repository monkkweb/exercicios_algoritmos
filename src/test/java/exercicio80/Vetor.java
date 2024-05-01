package exercicio80;

import java.util.Arrays;
import java.util.List;

public class Vetor {
    private Impressora impressora;
    private Leitor leitor;

    public Vetor(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        List<Integer> numerosDoVetorQ = Arrays.asList(leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler()
                , leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler()
                , leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler());
        int maiorNumeroDoVetor = numerosDoVetorQ.get(0);
        int posicaoDoMaiorVetor = 0;
        int posicaoAtualDoVetor = 0;

        for (int numeroDoVetor : numerosDoVetorQ) {
            if (numeroDoVetor < 0) {
                impressora.imprimirString("Só é aceito numeros positivos");
                return;
            }
            if (numeroDoVetor > maiorNumeroDoVetor) {
                maiorNumeroDoVetor = numeroDoVetor;
                posicaoDoMaiorVetor = posicaoAtualDoVetor;
            }
            posicaoAtualDoVetor++;
        }
        impressora.imprimirInt(maiorNumeroDoVetor);
        impressora.imprimirInt(posicaoDoMaiorVetor);
    }
}