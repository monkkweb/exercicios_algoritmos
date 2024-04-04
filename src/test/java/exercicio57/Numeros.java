package exercicio57;

public class Numeros {
    private Impressora impressora;
    private Leitor leitor;

    public Numeros(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void numerosCrescentes() {
        int tamanhoArray = leitor.ler();
        int[] resultado = new int[tamanhoArray];
        int valorDeN = 1;
        int indice = 0;

        while (indice < tamanhoArray) {
            resultado[indice] = valorDeN;
            valorDeN++;
            indice++;
        }
        impressora.imprimir(resultado);
    }
}
