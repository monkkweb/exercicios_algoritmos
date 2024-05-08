package exercicio86;

import ch.qos.logback.classic.turbo.MDCValueLevelPair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class Exercicio86Test {
    @Captor
    private ArgumentCaptor<Integer> argumentCaptor;

    @Test
    void deve_ler_dez_numeros_de_um_vetor() {
        ArrayList<Integer> numerosEsperados = (ArrayList<Integer>) Arrays.asList(5, 6, 7, 8, 9, 10);

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(numerosEsperados, argumentCaptor.getValue());
    }
}
