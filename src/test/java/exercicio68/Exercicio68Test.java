package exercicio68;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio68Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_calcular_valor_total_em_estoque() {
        Mockito.when(leitor.lerInt()).thenReturn(5);
        Mockito.when(leitor.lerDouble()).thenReturn(1d).thenReturn(5d).
                thenReturn(10d).thenReturn(6d).thenReturn(3d);
        var valorEsperado = 25;

        calculadora.calcular();

        Mockito.verify(impressora, Mockito.times(6)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getAllValues().get(4));
    }

    @Test
    void deve_calcular_media_dos_valores_de_cinco_mercadorias() {
        Mockito.when(leitor.lerInt()).thenReturn(5);
        Mockito.when(leitor.lerDouble()).thenReturn(1d)
                .thenReturn(5d).thenReturn(10d).thenReturn(6d).thenReturn(3d);
        var valorEsperado = 5.0;

        calculadora.calcular();

        Mockito.verify(impressora, Mockito.times(6)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }
}

