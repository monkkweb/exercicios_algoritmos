package exercicio69;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;


    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        double somatoriaDeValores = 0;
        int numeroDeEstoque = 0;
        String comando;
        do {
            numeroDeEstoque++;
            double valorDosProdutos = leitor.lerDouble();
            somatoriaDeValores += valorDosProdutos;
            impressora.imprimirDouble(somatoriaDeValores);

            impressora.imprimirString("Mais mercadoria?(S/N)");
            comando = leitor.lerString();
        } while (comando.equals("sim"));

        double mediaDeEstoque = somatoriaDeValores / numeroDeEstoque;
        impressora.imprimirDouble(mediaDeEstoque);

    }
}