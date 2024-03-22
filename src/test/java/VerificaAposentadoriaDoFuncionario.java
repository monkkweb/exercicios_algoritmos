import java.time.LocalDate;

public class VerificaAposentadoriaDoFuncionario {

    public Funcionario verificar(int codigo, int anoDeNascimento, int anoIngresso) {
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - anoDeNascimento;
        int tempoDeTrabalho = anoAtual - anoIngresso;
        int idadeMinimaParaAposentar = 65;
        boolean atingiuTempoEIdadeParaAposentar = (idade >= 60 && tempoDeTrabalho >= 25);
        int tempoMinimoDeTrabalhoParaAposentar = 30;
        String mensagemSeRequerOuNaoAposentadoria = (idade >= idadeMinimaParaAposentar ||
                tempoDeTrabalho >= tempoMinimoDeTrabalhoParaAposentar ||
                atingiuTempoEIdadeParaAposentar) ? "Requer aposentadoria" : "Não requer aposentadoria";

        return new Funcionario(codigo, idade, tempoDeTrabalho, mensagemSeRequerOuNaoAposentadoria);
    }
}

class Funcionario {
    int codigo;
    int idade;
    int tempoDeTrabalho;
    String mensagemSeRequerOuNaoAposentadoria;

    public Funcionario(int codigo, int idade, int tempoDeTrabalho, String mensagemSeRequerOuNaoAposentadoria) {
        this.codigo = codigo;
        this.idade = idade;
        this.tempoDeTrabalho = tempoDeTrabalho;
        this.mensagemSeRequerOuNaoAposentadoria = mensagemSeRequerOuNaoAposentadoria;
    }

}