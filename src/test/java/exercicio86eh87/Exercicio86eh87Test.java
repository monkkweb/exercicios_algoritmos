package exercicio86eh87;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio86eh87Test {
    @Captor
    private ArgumentCaptor<int[]> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    private Vetor vetor;

    @Test
    void deve_ler_dez_numeros_de_um_vetor_eh_mandar_os_numeros_em_ordem_crescente() {
        Mockito.when(leitor.ler()).thenReturn(5).thenReturn(9).thenReturn(8).thenReturn(7).thenReturn(6).thenReturn(10)
                .thenReturn(4).thenReturn(3).thenReturn(2).thenReturn(1);
        int[] ordemEsperada = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        vetor.crescente();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertArrayEquals(ordemEsperada, argumentCaptor.getAllValues().get(0));
    }

    @Test
    void deve_ler_dez_numeros_de_um_vetor_eh_deixar_em_ordem_crescente_depois_ler_outro_numero_eh_encaixar_na_ordem() {
        Mockito.when(leitor.ler()).thenReturn(5).thenReturn(9).thenReturn(8).thenReturn(7).thenReturn(6).thenReturn(10)
                .thenReturn(4).thenReturn(3).thenReturn(2).thenReturn(1)
                .thenReturn(5).thenReturn(9).thenReturn(8).thenReturn(7).thenReturn(6).thenReturn(10)
                .thenReturn(4).thenReturn(3).thenReturn(2).thenReturn(1).thenReturn(1);
        int[] ordemEsperada = new int[]{1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        vetor.crescente();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertArrayEquals(ordemEsperada, argumentCaptor.getAllValues().get(1));
    }
}
