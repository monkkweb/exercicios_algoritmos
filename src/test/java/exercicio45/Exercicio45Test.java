package exercicio45;

import lombok.var;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class Exercicio45Test {
    @Test
    public void enquanto_segundo_numero_for_zero_repete_segundo_valor() {
        var leitor = Mockito.mock(Leitor.class);
        Mockito.when(leitor.ler()).thenReturn(4.0).thenReturn(0.0).thenReturn(4.0);
        var impressora = Mockito.mock(Impressora.class);
        ArgumentCaptor<Double> argumentCaptor = ArgumentCaptor.forClass(Double.class);
        Calculadora calculadora = new Calculadora(impressora, leitor);

        calculadora.calcular();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
    }
}
