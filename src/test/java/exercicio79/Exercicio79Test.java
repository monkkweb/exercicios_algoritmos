package exercicio79;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class Exercicio79Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void ler_vinte_notas_e_calcular_a_media_da_turma() {
        Mockito.when(leitor.ler()).thenReturn(7d).thenReturn(1d).thenReturn(4d).thenReturn(9d).thenReturn(10d)
                .thenReturn(3d).thenReturn(8d).thenReturn(5d).thenReturn(6d).thenReturn(10d).thenReturn(4d)
                .thenReturn(5d).thenReturn(3d).thenReturn(8d).thenReturn(9d).thenReturn(1d).thenReturn(10d)
                .thenReturn(7d).thenReturn(1d).thenReturn(0d);
        var mediaEsperada = 5.55;

        calculadora.calcular();

        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getAllValues().get(0));
    }

    @Test
    void deve_imprimir_quantos_alunos_estao_com_as_notas_acima_da_media_de_seis() {
        Mockito.when(leitor.ler()).thenReturn(7d).thenReturn(1d).thenReturn(4d).thenReturn(9d).thenReturn(10d)
                .thenReturn(3d).thenReturn(8d).thenReturn(5d).thenReturn(6d).thenReturn(10d).thenReturn(4d)
                .thenReturn(5d).thenReturn(3d).thenReturn(8d).thenReturn(9d).thenReturn(1d).thenReturn(10d)
                .thenReturn(7d).thenReturn(1d).thenReturn(0d);
        var quandotidadeEsperada = 10;

        calculadora.calcular();

        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(quandotidadeEsperada, argumentCaptor.getAllValues().get(1));
    }
}
