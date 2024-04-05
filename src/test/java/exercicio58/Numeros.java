package exercicio58;

public class Numeros {
    private Impressora impressora;
    private Leitor leitor;

    public Numeros(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void numerosDeCrescente() {
        int tamanhhoArray = leitor.ler();
        int[] resultado = new int[tamanhhoArray];
        int valorDeN = leitor.ler();
        int indice = 0;
        while (valorDeN > 0) {
            resultado[indice] = valorDeN;
            valorDeN--;
            indice++;
        }
        impressora.imprimir(resultado);

    }
}