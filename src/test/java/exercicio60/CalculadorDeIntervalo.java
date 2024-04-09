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
             int numeros = leitor.ler();
            if (numeros <= 20 && numeros >= 10) {
                dentroDoIntervalo++;
                impressora.imprimirDentro(dentroDoIntervalo);
            }else {
                foraDoIntervalo++;
                impressora.imprimirFora(foraDoIntervalo);
            }
        }
    }
}