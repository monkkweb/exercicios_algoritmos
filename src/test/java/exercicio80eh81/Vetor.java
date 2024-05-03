package exercicio80eh81;

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
        int posicaoDoMaiorNumeroDoVetor = 0;
        int menorNumeroDoVetor = Integer.MAX_VALUE;
        int posicaoDoMenorNumeroDoVetor = Integer.MAX_VALUE;
        int posicaoAtualDoVetor = 0;

        for (int numeroDoVetor : numerosDoVetorQ) {
            if (numeroDoVetor < 0) {
                impressora.imprimirString("Só é aceito numeros positivos");
                return;
            }
            if (numeroDoVetor > maiorNumeroDoVetor) {
                maiorNumeroDoVetor = numeroDoVetor;
                posicaoDoMaiorNumeroDoVetor = posicaoAtualDoVetor;
            }
            if (numeroDoVetor < menorNumeroDoVetor) {
                menorNumeroDoVetor = numeroDoVetor;
                posicaoDoMenorNumeroDoVetor = posicaoAtualDoVetor;
            }
            posicaoAtualDoVetor++;
        }
        impressora.imprimirInt(maiorNumeroDoVetor);
        impressora.imprimirInt(posicaoDoMaiorNumeroDoVetor);
        impressora.imprimirInt(menorNumeroDoVetor);
        impressora.imprimirInt(posicaoDoMenorNumeroDoVetor);
    }
}