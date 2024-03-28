package exercicio48;


public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcularMedia() {
        double primeiraNota;
        double segundaNota;
        do {
            primeiraNota = leitor.ler();
            if (primeiraNota < 0)
                impressora.imprimir("nota um invalida");
        } while (primeiraNota < 0);

        do {
            segundaNota = leitor.ler();
            if (segundaNota < 0)
                impressora.imprimir("nota dois invalida");
        } while (segundaNota < 0);


        double mediaDoAluno = (primeiraNota + segundaNota) / 2;
        impressora.imprimir(mediaDoAluno);
    }
}