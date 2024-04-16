package exercicio71;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        double somatorioDeNumeros = 0;
        int quantidadeDeNumeros = leitor.lerInt();
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            double numeros = leitor.lerDouble();
            somatorioDeNumeros += numeros;
        }
        double media = somatorioDeNumeros / quantidadeDeNumeros;
        impressora.imprimir(media);
    }
}