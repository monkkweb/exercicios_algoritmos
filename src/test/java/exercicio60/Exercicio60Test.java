package exercicio60;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio60Test {
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    CalculadorDeIntervalo calculadorDeIntervalo;
    @Captor
    ArgumentCaptor<Integer> argumentCaptor;

    @Test
    void deve_imprimir_quantos_valores_estao_fora_do_intervalo_de_dez_ah_vinte() {
        Mockito.when(leitor.ler()).thenReturn(15).thenReturn(8).thenReturn(20).thenReturn(9);
        var valorEsperado = 8;

        calculadorDeIntervalo.calculaIntervalo();

        Mockito.verify(impressora, Mockito.times(8)).imprimirFora(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }

    @Test
    void deve_imprimir_quantos_valores_estao_dentro_do_intervalo_de_dez_ah_vinte() {
        Mockito.when(leitor.ler()).thenReturn(15).thenReturn(8).thenReturn(20).thenReturn(9);
        var valorEsperado = 2;

        calculadorDeIntervalo.calculaIntervalo();

        Mockito.verify(impressora, Mockito.times(2)).imprimirDentro(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }
}
