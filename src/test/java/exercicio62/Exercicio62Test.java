package exercicio62;

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
    ArgumentCaptor<Integer> argumentCaptorInteiro;
    @Captor
    ArgumentCaptor<Double> argumentCaptorDouble;

    @Test
    void deve_ler_quantidade_de_alunos_da_sala() {
        Mockito.when(leitor.ler()).thenReturn(2);
        int quantidadeDeAlunosEsperada = 2;

        alunos.quantidadeDeAlunos();

        Mockito.verify(impressora).imprimir(argumentCaptorInteiro.capture());
        Assertions.assertEquals(quantidadeDeAlunosEsperada, argumentCaptorInteiro.getValue());
    }

    @Test
    void calcular_media_dos_alunos(){
        Mockito.when(leitor.ler()).thenReturn(7);
        int mediaEsperada = 7;

        alunos.mediaDosAlunos();

        Mockito.verify(impressora).imprimir(argumentCaptorDouble.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptorDouble.getValue());
    }
}
