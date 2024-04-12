package exercicio69;

public class Caculadora {
    private Impressora impressora;
    private Leitor leitor;


    public Caculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        var numeroDeEstoque = leitor.ler();
        impressora.imprimir(numeroDeEstoque);
    }
}
