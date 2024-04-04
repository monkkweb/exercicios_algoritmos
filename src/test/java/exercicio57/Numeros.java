package exercicio57;

public class Numeros {
    private Impressora impressora;
    private Leitor leitor;

    public Numeros(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void numerosCrescentes() {
        int[] resultado = new int[leitor.ler()];
        int valorDeN = 1;
        while (valorDeN <= leitor.ler()) {
            resultado[valorDeN] = valorDeN++;
        }
        impressora.imprimir(resultado);

    }
}
