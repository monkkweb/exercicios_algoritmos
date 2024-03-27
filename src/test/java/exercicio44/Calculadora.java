package exercicio44;

import lombok.var;

public class Calculadora {
    private Leitor leitor;
    private Impressora impressora;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        var primeiroValor = leitor.ler();
        double segundoValor;

        do {
            segundoValor = leitor.ler();
        } while (segundoValor == 0);

        var resultado = primeiroValor / segundoValor;
        impressora.imprimir(resultado);
    }
}
