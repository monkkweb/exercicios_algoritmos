package exercicio64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class Exercicio64 {
    @Captor
    ArgumentCaptor<Integer> argumentCaptor;
    @Mock
    Impressora impressora;
    @Mock
    Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_somar_os_numeros_abaixo_de_40() {
        when(leitor.ler()).thenReturn(10).thenReturn(10).thenReturn(50);
        var somaEsperada = 20;

        calculadora.calcular();

        Mockito.verify(impressora, times(10)).imrprimir(argumentCaptor.capture());
        Assertions.assertEquals(somaEsperada, argumentCaptor.getValue());
    }
}