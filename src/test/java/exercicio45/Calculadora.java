package exercicio45;

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

        while (segundoValor == 0) {
            impressora.imprimirString("Valor invalido");
            segundoValor = leitor.ler();
        }

        var resultado = primeiroValor / segundoValor;
        impressora.imprimirDouble(resultado);
    }
}
