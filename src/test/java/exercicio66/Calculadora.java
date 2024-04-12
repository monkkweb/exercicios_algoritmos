package exercicio66;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        var soma = 0;

        var primeiroValor = leitor.ler();
        var segundoValor = leitor.ler();
        var valorInicial = Math.min(primeiroValor, segundoValor);
        var valorFinal = Math.max(primeiroValor, segundoValor);
        for (int i = valorInicial; i <= valorFinal; i++) {
            soma += i;
        }
        impressora.imprimir(soma);
    }
}
