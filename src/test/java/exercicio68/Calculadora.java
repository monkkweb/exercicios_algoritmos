package exercicio68;


public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        var numeroDeEstoque = leitor.lerInt();
        double somatoriaDevalores = 0;
        for (int i = 0; i < numeroDeEstoque; i++) {
            var valorDosProdutos = leitor.lerDouble();
            somatoriaDevalores += valorDosProdutos;
        }
        double media = somatoriaDevalores / numeroDeEstoque;
        impressora.imprimirDouble(media);

    }
}
