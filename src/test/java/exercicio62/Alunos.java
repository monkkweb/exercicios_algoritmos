package exercicio62;

public class Alunos {
    private Impressora impressora;
    private Leitor leitor;

    Alunos(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void quantidadeDeAlunos() {
        int numeroDeAlunos = leitor.ler();
        impressora.imprimir(numeroDeAlunos);

    }

    public void mediaDosAlunos() {
        double soma = 0;
        for (int valor = 0; valor < 4; valor++) {
            double nota = leitor.ler();
            soma += nota;
        }
        double media = soma / 4;
        impressora.imprimir(media);
    }
}