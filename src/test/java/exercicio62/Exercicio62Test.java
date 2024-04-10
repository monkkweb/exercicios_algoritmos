package exercicio62;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio62Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    Impressora impressora;
    @Mock
    Leitor leitor;
    @InjectMocks
    CalculadoraDeMediaDeAluno calculadora;


    @Test
    void deve_calcular_media_de_um_aluno_quando_usuario_digitar_um_aluno() {
        Mockito.when(leitor.ler()).thenReturn(1);
        Mockito.when(leitor.lerDouble()).thenReturn(10d);
        var mediaEsperada = 10;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void deve_calcular_media_dos_alunos_quando_usuario_digitar_cinco_alunos() {
        Mockito.when(leitor.ler()).thenReturn(5);
        Mockito.when(leitor.lerDouble()).thenReturn(7d).thenReturn(8d).thenReturn(5d)
                .thenReturn(2d).thenReturn(10d);
        var mediaEsperada = 6.4d;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void deve_calcular_media_dos_alunos_quando_usuario_digitar_cinco_alunos2() {
        Mockito.when(leitor.ler())
                .thenReturn(1);

        calculadora.calcular();

        Mockito.inOrder(leitor).verify(leitor).ler();
        Mockito.inOrder(leitor).verify(leitor).lerDouble();
    }
}
