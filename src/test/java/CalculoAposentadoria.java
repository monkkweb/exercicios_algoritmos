public class CalculoAposentadoria {

    int codigo;
    int idade;
    int tempoDeTrabalho;
    String mensagemSeRequerOuNaoAposentadoria;

    public CalculoAposentadoria(int codigo, int idade, int tempoDeTrabalho, String mensagemSeRequerOuNaoAposentadoria) {
        this.codigo = codigo;
        this.idade = idade;
        this.tempoDeTrabalho = tempoDeTrabalho;
        this.mensagemSeRequerOuNaoAposentadoria = mensagemSeRequerOuNaoAposentadoria;
    }
}
