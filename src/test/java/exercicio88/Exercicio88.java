package exercicio88;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio88 {
    @Captor
    private ArgumentCaptor<List<Integer>> argumentCaptor;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    private Vetor vetor;

    @Test
    void deve_ler_vetor_de_vinte_numeros() {
        Mockito.when(leitor.ler()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6)
                .thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10).thenReturn(11).thenReturn(12).thenReturn(13)
                .thenReturn(14).thenReturn(15).thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20);
        List<Integer> vetorEsperado = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        vetor.numerador();

        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptor.getAllValues().get(0));
    }
    @Test
    void ()
}
