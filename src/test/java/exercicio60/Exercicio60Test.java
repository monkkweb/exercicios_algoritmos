package exercicio60;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Exercicio60Test {
    @Captor
    private ArgumentCaptor<Integer> argumentCaptor;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    CalculadorDeIntervalo calculadorDeIntervalo;

    @Test
    void deve_imprimir_quantos_valores_estao_fora_do_intervalo_de_dez_ah_vinte() {
        Mockito.when(leitor.ler()).thenReturn(15).thenReturn(8).thenReturn(15).thenReturn(9);
        var valorEsperado = 8;

        calculadorDeIntervalo.calculaIntervalo();

        verify(impressora, Mockito.times(10)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }
    @Test
    void deve_imprimir_quantos_numeros_estao_dentro_do_intervalo_de_dez_ah_vinte() {
        Mockito.when(leitor.ler()).thenReturn(11).thenReturn(18).thenReturn(19).thenReturn(0);
        var valorEsperado = 3;

        calculadorDeIntervalo.calculaIntervalo();

        verify(impressora, Mockito.times(10)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getAllValues().get(2));
    }
}