package exercicio78;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

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
    void deve_exibir_mensagem_de_encontrar_pessoa_na_lista() {
        Mockito.when(leitor.ler()).thenReturn("Vinicios").thenReturn("Roberto").thenReturn("Maria").
                thenReturn("ed").thenReturn("Nabia").thenReturn("Vasco").thenReturn("blod")
                .thenReturn("penis").thenReturn("gama").thenReturn("ster").thenReturn("ster");
        var mensagemEsperada = "ENCONTRADA!";

        agenda.nomes();

        Mockito.verify(impressora, Mockito.times(3)).imprimir((String) argumentCaptor.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptor.getValue());
    }

    @Test
    void deve_exibir_mensagem_de_nao_encontrado_pessoa_na_lista() {
        Mockito.when(leitor.ler()).thenReturn("Vinicios").thenReturn("Roberto").thenReturn("Maria").
                thenReturn("ed").thenReturn("Nabia").thenReturn("Vasco").thenReturn("blod")
                .thenReturn("arabia").thenReturn("gama").thenReturn("ster").thenReturn("penisvaldo");
        var mensagemEsperada = "NÃO ENCONTRADA!";

        agenda.nomes();

        Mockito.verify(impressora, Mockito.times(3)).imprimir((String) argumentCaptor.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptor.getValue());
    }
}
