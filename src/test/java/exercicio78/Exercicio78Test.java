package exercicio78;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Exercicio78Test {
    @Captor
    ArgumentCaptor argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Agenda agenda;

    @Test
    void deve_exibir_mensagem_de_pessoa_encontrada_na_lista() {
        when(leitor.ler()).thenReturn("Vinicios").thenReturn("Roberto").thenReturn("Maria").
                thenReturn("Ed").thenReturn("Nabia").thenReturn("Vasco").thenReturn("Blod")
                .thenReturn("Deni").thenReturn("Gama").thenReturn("Ster").thenReturn("Ster");
        var mensagemEsperada = "ENCONTRADA!";

        agenda.nomes();

        Mockito.verify(impressora, Mockito.times(3)).imprimir((String) argumentCaptor.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptor.getValue());
    }

    @Test
    void deve_exibir_mensagem_de_pessoa_nao_encontrada_na_lista() {
        when(leitor.ler()).thenReturn("Vinicios").thenReturn("Roberto").thenReturn("Maria").
                thenReturn("Ed").thenReturn("Nabia").thenReturn("Vasco").thenReturn("Blod")
                .thenReturn("Deni").thenReturn("Gama").thenReturn("Ster").thenReturn("Penisvaldo");
        var mensagemEsperada = "NÃO ENCONTRADA!";

        agenda.nomes();

        Mockito.verify(impressora, Mockito.times(3)).imprimir((String) argumentCaptor.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptor.getValue());
    }
}
