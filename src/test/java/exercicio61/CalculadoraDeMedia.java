package exercicio61;

public class CalculadoraDeMedia {
    private Impressora impressora;
    private Leitor leitor;

    CalculadoraDeMedia(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcularMedia() {
        double soma = 0;
        for (int valores = 0; valores < 10; valores++) {
            double numero = leitor.ler();
            soma += numero;
        }
        double media = soma / 10;
        impressora.imprimir(media);
    }
}
