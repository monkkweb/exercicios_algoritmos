package exercicio69;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio69 {

    @Captor
    ArgumentCaptor<Integer> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Caculadora calculadora;

    @Test
    void deve_ler_valor_total_de_mercadoria() {
        Mockito.when(leitor.ler()).thenReturn(5);
        var valorEsperado = 5;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }
}
