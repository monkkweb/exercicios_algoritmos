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
    @InjectMocks
    Calculadora calculadora;
    @Mock
    private Impressora impressora;

    @Test
    void deve_ler_valor_de_cada_mercadoria() {
        Mockito.when(leitor.lerInt()).thenReturn(5);
        Mockito.when(leitor.lerDouble()).thenReturn(1d)
                .thenReturn(5d).thenReturn(10d).thenReturn(6d).thenReturn(3d);
        var valorEsperado = 5.0;

        calculadora.calcular();

        Mockito.verify(impressora).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }
}

