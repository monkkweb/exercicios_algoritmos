package exercicio59;

public class Numeros {
    private Impressora impressora;
    private Leitor leitor;

    public Numeros(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void lerNumerosEImprimirOsNegativos() {
        int numeroNegativo = 0;
        for (int i = 0; i < 10; i++) {
            int numero = leitor.ler();
            if (numero < 0) {
                numeroNegativo++;
                impressora.imprimir(numeroNegativo);
            }

        }
    }
}