package exercicio62;

public class Alunos {
    private Impressora impressora;
    private Leitor leitor;

    Alunos(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void mediaAlunos() {
        int quantidadeDeAunos = leitor.ler();
        impressora.imprimir(quantidadeDeAunos);
    }
}
