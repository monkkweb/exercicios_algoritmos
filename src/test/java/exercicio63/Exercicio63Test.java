package exercicio63;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio63Test {
    @Captor
    ArgumentCaptor<Integer> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;

    @InjectMocks
    Calculadora calculadora;
    @Test
    void deve_lee_dez_numeros_e_somar_tudo(){
        Mockito.when(leitor.ler()).thenReturn(2);
        int somaEsperada = 20;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(somaEsperada, argumentCaptor.getValue());
    }
}
