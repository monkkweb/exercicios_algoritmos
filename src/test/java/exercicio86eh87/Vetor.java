package exercicio86eh87;


import java.util.Arrays;

public class Vetor {

    private Leitor leitor;
    private Impressora impressora;

    public Vetor(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void crescente() {
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = leitor.ler();
        }

        Arrays.sort(numeros);
        impressora.imprimir(numeros);

        int[] numerosRefatorado = new int[11];
        for (int i = 0; i < 11; i++) {
            numerosRefatorado[i] = leitor.ler();
        }

        Arrays.sort(numerosRefatorado);
        impressora.imprimir(numerosRefatorado);
    }
}
