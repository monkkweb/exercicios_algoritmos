package exercicio60;

public class CalculadorDeIntervalo {
    private Impressora impressora;
    private Leitor leitor;

    public CalculadorDeIntervalo(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calculaIntervalo() {
        int foraDoIntervalo = 0;
        int dentroDoIntervalo = 0;
        for (int i = 0; i < 10; i++) {
            int numero = leitor.ler();
            if (numero <= 20 && numero >= 10) {
                dentroDoIntervalo++;
                impressora.imprimir(dentroDoIntervalo);
            } else {
                foraDoIntervalo++;
                impressora.imprimir(foraDoIntervalo);
            }
        }
        System.out.println(dentroDoIntervalo);
    }
}