package exercicio70;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio70Test {
    @Captor
    ArgumentCaptor<Integer> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_imprimir_o_maior_numero_de_cem_valores() {
        Mockito.when(leitor.ler()).thenReturn(5).thenReturn(4);
        var numeroEsperado = 5;

        calculadora.calcular();
        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(numeroEsperado, argumentCaptor.getAllValues().get(0));
    }

    @Test
    void deve_imprimir_o_menor_numero_de_cem_valores() {
        Mockito.when(leitor.ler()).thenReturn(3).thenReturn(22);
        var numeroEsperado = 3;

        calculadora.calcular();

        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(numeroEsperado, argumentCaptor.getAllValues().get(1));
    }
}
