package exercicio84;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio84Test {
    @Captor
    ArgumentCaptor<List<Integer>> argumentCaptor;
    @Mock
    Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Vetor vetor;

    @Test
    void deve_imprimir_o_vetorA() {
        Mockito.when(leitor.ler()).thenReturn(5).thenReturn(5).thenReturn(10).thenReturn(15).thenReturn(20)
                .thenReturn(25);
        List<Integer> vetorEsperado = Arrays.asList(5, 10, 15, 20, 25);

        vetor.calcular();

        Mockito.verify(impressora, Mockito.times(3)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptor.getAllValues().get(0));
    }

    @Test
    void deve_imprimir_o_vetorB() {
        Mockito.when(leitor.ler()).thenReturn(4).thenReturn(5).thenReturn(10).thenReturn(15).thenReturn(20)
                .thenReturn(5).thenReturn(10).thenReturn(15).thenReturn(20);
        List<Integer> vetorEsperado = Arrays.asList(5, 10, 15, 20);

        vetor.calcular();

        Mockito.verify(impressora, Mockito.times(3)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptor.getAllValues().get(1));
    }

    @Test
    void deve_imprimir_o_vetorSoma() {
        Mockito.when(leitor.ler()).thenReturn(4).thenReturn(5).thenReturn(10).thenReturn(15).thenReturn(20)
                .thenReturn(5).thenReturn(10).thenReturn(15).thenReturn(20);
        List<Integer> vetorEsperado = Arrays.asList(10, 20, 30, 40);

        vetor.calcular();

        Mockito.verify(impressora, Mockito.times(3)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptor.getAllValues().get(2));
    }
}
