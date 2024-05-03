package exercicio71;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio71Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_calcular_media_dos_numeros_ditos_de_acordo_com_a_quantidade_declarada() {
        Mockito.when(leitor.lerInt()).thenReturn(4);
        Mockito.when(leitor.lerDouble()).thenReturn(7d).thenReturn(7d).thenReturn(7d).thenReturn(7d);
        var mediaEsperada = 7;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void deve_ler_uma_quantidade() {
        Mockito.when(leitor.lerInt()).thenReturn(1);

        calculadora.calcular();

        Mockito.inOrder(leitor).verify(leitor).lerInt();
        Mockito.inOrder(leitor).verify(leitor).lerDouble();
    }
}
