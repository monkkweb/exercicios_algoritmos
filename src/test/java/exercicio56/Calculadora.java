package exercicio56;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void tabuada() {
        int numeroDaMultiplicacao = leitor.ler();
        int[] resultado = new int[10];
        for (int numeroDaTabuada = 0; numeroDaTabuada < 10; numeroDaTabuada++) {
            resultado[numeroDaTabuada] = (numeroDaMultiplicacao * (1 + numeroDaTabuada));
        }
        impressora.imprimir(resultado);
    }
}
