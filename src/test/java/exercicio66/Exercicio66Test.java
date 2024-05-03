package exercicio66;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio66Test {
    public static final int NUMERO_ESPERADO = 15;
    @Captor
    ArgumentCaptor<Integer> argumentCaptorInt;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_somar_numeros_inteiros_entre_segundo_eh_primeiro_numero() {
        Mockito.when(leitor.ler()).thenReturn(1).thenReturn(5);

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptorInt.capture());
        Assertions.assertEquals(NUMERO_ESPERADO, argumentCaptorInt.getValue());
    }

    @Test
    void deve_somar_numeros_inteiros_entre_primeiro_eh_segundo_numero() {
        Mockito.when(leitor.ler()).thenReturn(5).thenReturn(1);

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptorInt.capture());
        Assertions.assertEquals(NUMERO_ESPERADO, argumentCaptorInt.getValue());
    }
}
