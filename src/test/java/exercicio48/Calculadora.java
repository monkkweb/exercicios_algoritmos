package exercicio48;


public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcularMedia() {
        double notaUm;
        double notaDois;
        do {
            notaUm = leitor.ler();
            if (notaUm < 0)
                impressora.imprimir("nota um invalida");
        } while (notaUm < 0);

        do {
            notaDois = leitor.ler();
            if (notaDois < 0)
                impressora.imprimir("nota dois invalida");
        } while (notaDois < 0);


        double media = (notaUm + notaDois) / 2;
        impressora.imprimir(media);
    }
}