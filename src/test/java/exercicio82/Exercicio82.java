package exercicio82;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio82 {
    @Captor
    ArgumentCaptor<List<Double>> argumentCaptor;
    @Mock
    Leitor leitor;
    @Mock
    Impressora impressora;
    @InjectMocks
    Vetor vetor;

    @Test
    void deve_emprimir_vetor_M() {
        Mockito.when(leitor.ler()).thenReturn(3d).thenReturn(7d).thenReturn(9d).thenReturn(1d).thenReturn(8d)
                .thenReturn(5d).thenReturn(10d).thenReturn(2d).thenReturn(4d).thenReturn(6d).thenReturn(2d);
        List<Double> vetorEsperado = Arrays.asList(6.0, 14.0, 18.0, 2.0, 16.0, 10.0, 20.0, 4.0, 8.0, 12.0);

        vetor.calcular();

        Mockito.verify(impressora,Mockito.times(10)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptor.getValue());
    }
}
