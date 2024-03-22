import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class exercicio42Test {

    @InjectMocks
    private VerificaAposentadoriaDoFuncionario aposentadoria;
    private int anoAtual;

    @BeforeEach
    public void init() {
        anoAtual = LocalDate.now().getYear();
    }

    @ParameterizedTest(name = "codigo: {0} ano de nascimento: {1} e ano de engressado: {2}")
    @CsvSource({"2,1950,2000", "3,2010,1994", "4,1964,1999"})

    public void sessenta_e_cinco_anos_para_se_aposentar_ou_ter_trinta_anos_de_trabalho_ou_minimo_sessenta_anos_e_vinte_e_cinco_anos_de_trabalho_para_se_aposentar
            (int codigo, int anoDeNascimento, int anoDeIngresso) {

        int idade = anoAtual - anoDeNascimento;
        int tempoDeTrabalho = anoAtual - anoDeIngresso;

        Funcionario funcionario = aposentadoria.verificar(codigo, anoDeNascimento, anoDeIngresso);

        Assertions.assertEquals("Requer aposentadoria", funcionario.mensagemSeRequerOuNaoAposentadoria);
        Assertions.assertEquals(idade, funcionario.idade);
        Assertions.assertEquals(tempoDeTrabalho, funcionario.tempoDeTrabalho);
    }
    // ano de ingresso nao pode ser menor que a data de nascimento
    // data atual nao pode ser menor que a ano de nanscimeto
    // data atual nao pode ser menor que data de ingresso
}
