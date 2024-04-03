package exercicio53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio53 {
    @Captor
    ArgumentCaptor<List<Integer>> arrayArgumentCaptor;

    @Test
    public void contador_de_numeros_inteiros_ate_valor_n() {
        Impressora impressora = Mockito.mock(Impressora.class);
        Leitor leitor = Mockito.mock(Leitor.class);
        Mockito.when(leitor.ler()).thenReturn(5);
        List<Integer> numerosEsperados = Arrays.asList(1, 2, 3, 4, 5);

        Numeros numeros = new Numeros(leitor, impressora);

        numeros.calcularNumerosInteiros();

        Mockito.verify(impressora).imprimir(arrayArgumentCaptor.capture());

        Assertions.assertEquals(numerosEsperados, arrayArgumentCaptor.getValue());
    }
}
