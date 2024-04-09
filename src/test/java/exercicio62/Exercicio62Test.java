package exercicio62;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio62Test {
    @InjectMocks
    Alunos alunos;
    @Mock
    Impressora impressora;
    @Mock
    Leitor leitor;
    @Captor
    ArgumentCaptor<Integer> argumentCaptor;

    @Test
    void deve_ler_quantidade_de_alunos_da_sala() {
        Mockito.when(leitor.ler()).thenReturn(2);
        int quantidadeDeAlunosEsperada = 2;

        alunos.mediaAlunos();

        Mockito.verify(impressora).imprimir(argumentCaptor.captor());
        Assertions.assertEquals(quantidadeDeAlunosEsperada, argumentCaptor.getValue());

    }
}
