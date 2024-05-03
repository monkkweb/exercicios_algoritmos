package exercicio69;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio69Test {
    @Captor
    ArgumentCaptor<Double> argumetCaptorDouble;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_calcular_media_de_estoque() {
        Mockito.when(leitor.lerDouble()).thenReturn(4d).thenReturn(5d).thenReturn(9d);
        Mockito.when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("não");
        var mediaEsperada = 6.75;

        calculadora.calcular();

        Mockito.verify(impressora,Mockito.times(5)).imprimirDouble(argumetCaptorDouble.capture());
        Assertions.assertEquals(mediaEsperada, argumetCaptorDouble.getValue());
    }

    @Test
    void deve_mostrar_o_valor_total_em_estoque() {
        Mockito.when(leitor.lerDouble()).thenReturn(4d).thenReturn(5d).thenReturn(9d);
        Mockito.when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("não");
        var volorTotalEsperado = 27;
        calculadora.calcular();

        Mockito.verify(impressora, Mockito.times(5)).imprimirDouble(argumetCaptorDouble.capture());
        Assertions.assertEquals(volorTotalEsperado, argumetCaptorDouble.getAllValues().get(3));
    }
    @Test
    void deve_mostrar_o_valor_de_cada_mercadoria(){
        Mockito.when(leitor.lerDouble()).thenReturn(6d);
        Mockito.when(leitor.lerString()).thenReturn("não");
        var valorEsperado = 6;

        calculadora.calcular();

         Mockito.verify(impressora, Mockito.times(2)).imprimirDouble(argumetCaptorDouble.capture());
        Assertions.assertEquals(valorEsperado, argumetCaptorDouble.getValue());
    }
}
