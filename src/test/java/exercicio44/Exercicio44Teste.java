package exercicio44;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Exercicio44Teste {

    @Test
    public void O_segundo_valor_tem_que_ser_diferente_de_zero() {
        var impressora = mock(Impressora.class);
        var leitor = mock(Leitor.class);
        when(leitor.ler()).thenReturn(4.0).thenReturn(2.0);
        Calculadora calculadora = new Calculadora(impressora, leitor);
        ArgumentCaptor<Double> argumentcaptor = ArgumentCaptor.forClass(Double.class);
        double valorEsperado = 2;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentcaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentcaptor.getValue());
    }

    @Test
    public void enquanto_o_segundo_valor_for_zero_repita() {
        var impressora = mock(Impressora.class);
        var leitor = mock(Leitor.class);
        when(leitor.ler()).thenReturn(5.0).thenReturn(0.0).thenReturn(5.0);
        Calculadora calculadora = new Calculadora(impressora, leitor);
        ArgumentCaptor<Double> argumentcaptor = ArgumentCaptor.forClass(Double.class);
        double valorEsperado = 1;

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentcaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentcaptor.getValue());
    }
}
