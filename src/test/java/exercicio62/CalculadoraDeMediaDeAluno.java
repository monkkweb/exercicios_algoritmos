package exercicio62;

public class CalculadoraDeMediaDeAluno {
    private Impressora impressora;
    private Leitor leitor;

    CalculadoraDeMediaDeAluno(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        int quantidadeDeAluno = leitor.ler();
        double somatorioDeNotas = 0;
        for (int i = 0; i < quantidadeDeAluno; i++) {
            double nota = leitor.lerDouble();
            somatorioDeNotas += nota;
        }
        double media = somatorioDeNotas / quantidadeDeAluno;
        impressora.imprimir(media);
    }
}