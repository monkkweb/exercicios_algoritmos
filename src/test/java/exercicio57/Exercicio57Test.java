package exercicio57;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio57Test {
    @Mock
    public Impressora impressora;
    @Mock
    public Leitor leitor;
    @InjectMocks
    private Numeros numeros;
    @Captor
    ArgumentCaptor<int[]> argumentCaptor;

    @Test
    void tem_que_exibir_ordem_crescente_zero_ah_valor_n() {
        Mockito.when(leitor.ler()).thenReturn(20);
        int[] ordemEsperada = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        numeros.numerosCrescentes();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertArrayEquals(ordemEsperada, argumentCaptor.getValue());
    }
}
