package exercicio44;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class Exercicio44Teste {

    @Test
    public void O_segundo_valor_tem_que_ser_diferente_de_zero() {
        var impressora = Mockito.mock(Impressora.class);
        Calculadora calculadora = new Calculadora(impressora);
        double valorEsperado = 2;
        ArgumentCaptor<Double> argumentcaptor = ArgumentCaptor.forClass(Double.class);

        calculadora.calcular(4, 2);

        Mockito.verify(impressora).imprimir(argumentcaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentcaptor.getValue());
    }
}
