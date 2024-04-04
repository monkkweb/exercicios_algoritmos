package exercicio56;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class exercicio56Test {
    @Mock
    public Leitor leitor;
    @Mock
    public Impressora impressora;
    @Captor
    ArgumentCaptor<int[]> arrayArgumentCaptor;
    @InjectMocks
    private Calculadora calculadora;

    @Test
    public void valor_n_tem_que_ser_multiplicado_de_um_a_dez() {
        Mockito.when(leitor.ler()).thenReturn(2);
        int[] numerosEsperados = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        calculadora.tabuada();

        Mockito.verify(impressora).imprimir(arrayArgumentCaptor.capture());
        Assertions.assertArrayEquals(numerosEsperados, arrayArgumentCaptor.getValue());
    }
}
