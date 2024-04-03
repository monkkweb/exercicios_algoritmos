package exercicio56;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

public class exercicio56Test {
    @Mock
    public Leitor leitor;
    @Mock
    public Impressora impressora;
    @Captor
    ArgumentCaptor<List> arrayArgumentCaptor;
    @InjectMocks
    private Calculadora calculadora;

    @Test
    public void valor_n_tem_que_ser_multiplicado_de_um_a_dez() {
        Mockito.when(leitor.ler()).thenReturn(1);
        List<Integer> numerosEsperados = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        calculadora.tabuada();

        Mockito.verify(impressora).imprimir(arrayArgumentCaptor.capture());
        Assertions.assertEquals(numerosEsperados, arrayArgumentCaptor.getValue());
    }
}
