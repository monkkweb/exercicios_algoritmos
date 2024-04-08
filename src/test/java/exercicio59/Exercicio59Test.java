package exercicio59;

import java.util.List;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio59Test {
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Numeros numeros;
    @Captor
    ArgumentCaptor<int[]> argumentCaptor;

    @Test
    void deve_imprimir_quantos_numeros_sao_negativos() {
        Mockito.when(leitor.ler()).thenReturn(-2).thenReturn(5).thenReturn(-3).thenReturn(8);
        int[] numerosEsperados = new int[]{-2, -3};

        numeros.lerNumerosEImprimirOsNegativos();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertArrayEquals(numerosEsperados, argumentCaptor.getValue());

    }
}
