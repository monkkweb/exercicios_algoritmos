package exercicio44;

public class Calculadora {
    private Leitor leitor;
    private Impressora impressora;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        var primeiroValor = leitor.ler();
        double segundoValor = leitor.ler();

        do {
            if (segundoValor == 0)
                impressora.imprimir("valor invalido");
            segundoValor = leitor.ler();
        } while (segundoValor == 0);


        var resultado = primeiroValor / segundoValor;
        impressora.imprimir(resultado);
    }
}