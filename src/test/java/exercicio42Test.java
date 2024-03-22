import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class exercicio42Test {

    @Test
    public void sessenta_e_cinco_anos_para_se_aposentar() {
        int codigo = 2;
        int anoDeNascimento = 1950;
        int anoDeIngresso = 2000;
        int idade = LocalDate.now().getYear() - anoDeNascimento;
        int tempoDeTrabalho = LocalDate.now().getYear() - anoDeIngresso;

        VerificaAposentadoriaDoFuncionario aposentadoria = new VerificaAposentadoriaDoFuncionario();

        Funcionario funcionario = aposentadoria.verificar(codigo, anoDeNascimento, anoDeIngresso);

        Assertions.assertEquals("Requer aposentadoria", funcionario.mensagemSeRequerOuNaoAposentadoria);
        Assertions.assertEquals(idade, funcionario.idade);
        Assertions.assertEquals(tempoDeTrabalho, funcionario.tempoDeTrabalho);
    }

    @Test
    public void minimo_de_trinta_anos_de_trabalho_para_se_aposentar() {
        int codigo = 3;
        int anoDeNascimento = 2010;
        int anoDeIngresso = 1994;
        int idade = LocalDate.now().getYear() - anoDeNascimento;
        int tempoDeTrabalho = LocalDate.now().getYear() - anoDeIngresso;

        VerificaAposentadoriaDoFuncionario aposentadoria = new VerificaAposentadoriaDoFuncionario();

        Funcionario funcionario = aposentadoria.verificar(codigo, anoDeNascimento, anoDeIngresso);

        Assertions.assertEquals("Requer aposentadoria", funcionario.mensagemSeRequerOuNaoAposentadoria);
        Assertions.assertEquals(idade, funcionario.idade);
        Assertions.assertEquals(tempoDeTrabalho, funcionario.tempoDeTrabalho);
    }

    @Test
    public void minimo_sessenta_anos_e_vinte_e_cinco_anos_de_trabalho_para_se_aposentar() {
        int codigo = 4;
        int anoDeNascimento = 1964;
        int anoDeIngresso = 1999;
        int idade = LocalDate.now().getYear() - anoDeNascimento;
        int tempoDeTrabalho = LocalDate.now().getYear() - anoDeIngresso;

        VerificaAposentadoriaDoFuncionario aposentadoria = new VerificaAposentadoriaDoFuncionario();
        Funcionario funcionario = aposentadoria.verificar(codigo, anoDeNascimento, anoDeIngresso);

        Assertions.assertEquals("Requer aposentadoria", funcionario.mensagemSeRequerOuNaoAposentadoria);
        Assertions.assertEquals(idade, funcionario.idade);
        Assertions.assertEquals(tempoDeTrabalho, funcionario.tempoDeTrabalho);
    }
}
