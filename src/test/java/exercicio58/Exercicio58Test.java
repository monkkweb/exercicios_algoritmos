package exercicio58;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio58Test {
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Numeros numeros;
    @Captor
    ArgumentCaptor<int[]> argumentCaptor;

    @Test
    void tem_que_exibir_ordem_decresente_de_numero_n_ah_um() {
        Mockito.when(leitor.ler()).thenReturn(20);
        int[] ordemEsperada = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        numeros.numerosDeCrescente();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertArrayEquals(ordemEsperada, argumentCaptor.getValue());
    }
}
