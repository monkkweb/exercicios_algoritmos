package exercicio63;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio63Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;

    @InjectMocks
    Calculadora calculadora;
    @Test
    void deve_ler_dez_numeros_e_somar_tudo(){
        Mockito.when(leitor.ler()).thenReturn(2);
        var somaEsperada = 20d;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(somaEsperada, argumentCaptor.getValue());
    }
}
