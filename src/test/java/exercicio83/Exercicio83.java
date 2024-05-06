package exercicio83;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio83 {
    @Captor
    ArgumentCaptor<List<Integer>> argumentCaptor;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Vetor vetor;

    @Test
    void dev_ler_vetor() {
        Mockito.when(leitor.ler()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10).thenReturn(11)
                .thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15).thenReturn(16).thenReturn(17)
                .thenReturn(18).thenReturn(19).thenReturn(20);
        List<Integer> vetorEsperado = Arrays.asList(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        vetor.inverter();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptor.getValue());
    }
}
