package exercicio53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio53Test {
    @Captor
    ArgumentCaptor<List<Integer>> arrayArgumentCaptor;
    @Mock
    public Leitor leitor;
    @Mock
    public Impressora impressora;
    @InjectMocks
    private Numeros numeros;

    @Test
    void contador_de_numeros_inteiros_ate_valor_n() {
        Mockito.when(leitor.lerInteiro()).thenReturn(5);
        List<Integer> numerosEsperados = Arrays.asList(1, 2, 3, 4, 5);

        numeros.calcularNumerosInteiros();

        Mockito.verify(impressora).imprimir(arrayArgumentCaptor.capture());
        Assertions.assertEquals(numerosEsperados, arrayArgumentCaptor.getValue());
    }

    @Test
    void quando_valor_n_for_a_baixo_de_zero_deve_emitir_novo_valor() {
        Mockito.when(leitor.lerInteiro()).thenReturn(-1).thenReturn(5);
        List<Integer> numeroEsperado = Arrays.asList(1, 2, 3, 4, 5);

        numeros.calcularNumerosInteiros();

        Mockito.verify(impressora).imprimir(arrayArgumentCaptor.capture());
        Assertions.assertEquals(numeroEsperado, arrayArgumentCaptor.getValue());
    }
}
