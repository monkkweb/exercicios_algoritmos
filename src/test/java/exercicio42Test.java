import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class exercicio42Test {

    public static final LocalDate DATA_ATUAL = LocalDate.of(2024, 03, 25);
    public static final int CODIGO = 11;
    public static final String MENSAGEM_ESPERADA_REQUER_APOSENTADORIA = "Requer aposentadoria";
    public static final int ANO_DE_NASCIMENTO_NAO_APOSENTAVEL = 2014;
    @InjectMocks
    private VerificaAposentadoriaDoFuncionario aposentadoria;

    @Test
    public void ter_minimo_sessenta_e_cinco_anos_para_se_aposentar() {
        int anoDeNascimento = 1959;
        int anoDeIngresso = 1960;

        CalculoAposentadoria funcionario;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            funcionario = aposentadoria.verificar(CODIGO, anoDeNascimento, anoDeIngresso);
        }

        Assertions.assertEquals(MENSAGEM_ESPERADA_REQUER_APOSENTADORIA, funcionario.mensagemSeRequerOuNaoAposentadoria);
    }

    @Test
    public void ter_minimo_trinta_anos_de_trabalho() {
        int anoDeNascimento = 1987;
        int anoDeIngresso = 1994;

        CalculoAposentadoria funcionario;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            funcionario = aposentadoria.verificar(CODIGO, anoDeNascimento, anoDeIngresso);
        }

        Assertions.assertEquals(MENSAGEM_ESPERADA_REQUER_APOSENTADORIA, funcionario.mensagemSeRequerOuNaoAposentadoria);
    }

    @Test
    public void ter_sessenta_anos_e_vinte_e_cinco_anos_de_trabalho_para_se_aposentar() {
        int anoDeNascimento = 1964;
        int anoDeIngresso = 1999;

        CalculoAposentadoria funcionario;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            funcionario = aposentadoria.verificar(CODIGO, anoDeNascimento, anoDeIngresso);
        }

        Assertions.assertEquals(MENSAGEM_ESPERADA_REQUER_APOSENTADORIA, funcionario.mensagemSeRequerOuNaoAposentadoria);
    }

    @Test
    public void funcionario_nao_requer_aposentadoria() {
        String mensagemEsperada = "Não requer aposentadoria";
        int anoDeIngresso = 2015;

        CalculoAposentadoria funcionario;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            funcionario = aposentadoria.verificar(CODIGO, ANO_DE_NASCIMENTO_NAO_APOSENTAVEL, anoDeIngresso);
        }

        Assertions.assertEquals(mensagemEsperada, funcionario.mensagemSeRequerOuNaoAposentadoria);
    }

    @Test
    public void idade_do_funcionario() {
        int anoDeNascimento = 1994;
        int anoDeIngresso = 2015;
        int idadeDoFuncionario = 30;

        CalculoAposentadoria funcionario;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            funcionario = aposentadoria.verificar(CODIGO, anoDeNascimento, anoDeIngresso);
        }
        Assertions.assertEquals(idadeDoFuncionario, funcionario.idade);
    }

    @Test
    public void tempo_de_trabalho_do_funcionario() {
        int anoDeNascimento = 1994;
        int anoDeIngresso = 2015;
        int tempoDeTrabalho = 9;

        CalculoAposentadoria funcionario;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            funcionario = aposentadoria.verificar(CODIGO, anoDeNascimento, anoDeIngresso);
        }
        Assertions.assertEquals(tempoDeTrabalho, funcionario.tempoDeTrabalho);
    }

    @Test
    public void data_atual_nao_pode_ser_menor_que_ano_de_nascimento() {
        String mensagemEsperada = "Ano atual não pode ser menor que ano de nascimento.";
        int anoDeNascimento = 2027;
        int AnoDeIngresso = 2050;

        RuntimeException excecao;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            excecao = Assertions.assertThrows(RuntimeException.class, () -> aposentadoria.verificar(CODIGO,
                    anoDeNascimento, AnoDeIngresso));
        }

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }

    @Test
    public void data_atual_nao_pode_ser_menor_que_ano_de_ingresso() {
        String mensagemEsperada = "Ano de ingresso não pode ser maior que o ano atual.";
        int anoDeNascimento = 1995;
        int anoDeIngresso = 2027;

        RuntimeException excecao;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            excecao = Assertions.assertThrows(RuntimeException.class, () -> aposentadoria.verificar(CODIGO,
                    anoDeNascimento, anoDeIngresso));
        }

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }

    @Test
    public void ano_de_ingresso_nao_pode_ser_menor_que_data_de_nascimento() {
        String mensagemEsperada = "Ano de nascimento não pode ser maior que o ano atual.";
        int anoDeIngresso = 2000;

        RuntimeException excecao;
        try (MockedStatic<LocalDate> mock = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mock.when(LocalDate::now).thenReturn(DATA_ATUAL);
            excecao = Assertions.assertThrows(RuntimeException.class, () -> aposentadoria.verificar(CODIGO,
                    ANO_DE_NASCIMENTO_NAO_APOSENTAVEL, anoDeIngresso));
        }

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }
}
