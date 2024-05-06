package exercicio48;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitorDouble) {
        this.impressora = impressora;
        this.leitor = leitorDouble;
    }

    public void calcularMedia() {
        double primeiraNota;
        double segundaNota;
        String comando;
        do {
            do {
                primeiraNota = leitor.lerDouble();
                if (primeiraNota < 0 || primeiraNota > 10)
                    impressora.imprimir("primeira nota invalida");
            } while (primeiraNota < 0 || primeiraNota > 10);

            do {
                segundaNota = leitor.lerDouble();
                if (segundaNota < 0 || segundaNota > 10)
                    impressora.imprimir("segunda nota invalida");
            } while (segundaNota < 0 || segundaNota > 10);

            double mediaDoAluno = (primeiraNota + segundaNota) / 2;
            impressora.imprimir(mediaDoAluno);

            impressora.imprimir("novo calculo?(S/N)");
            comando = leitor.lerString();
        } while (comando.equals("sim"));

    }
}