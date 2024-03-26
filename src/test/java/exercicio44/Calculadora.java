package exercicio44;

import lombok.var;

public class Calculadora {
    private Impressora impressora;

    public Calculadora(Impressora impressora) {
        this.impressora = impressora;
    }

    public void calcular(double primeiroValor, double segundoValor) {
        var resultado = primeiroValor / segundoValor;
        impressora.imprimir(resultado);
    }
}
