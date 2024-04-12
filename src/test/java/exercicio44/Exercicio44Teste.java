package exercicio44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Exercicio44Teste {

    @Mock
    public Impressora impressora;
    @Mock
    public Leitor leitor;
    @InjectMocks
    private Calculadora calculadora;
    @Captor
    private ArgumentCaptor<Double> argumentCaptor;
    @Captor
    private ArgumentCaptor<String> argumentCaptorString;

    @Test
    public void o_segundo_valor_tem_que_ser_diferente_de_zero() {
        var valorEsperado = 1.0;
        when(leitor.ler()).thenReturn(4.0).thenReturn(4.0);

        calculadora.calcular();

        Mockito.verify(impressora).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }

    @Test
    public void enquanto_o_segundo_valor_for_zero_repita() {
        var valorEsperado = 1.0;
        when(leitor.ler()).thenReturn(5.0).thenReturn(0.0).thenReturn(5.0);

        calculadora.calcular();

        Mockito.verify(impressora).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }

    @Test
    public void deve_retornar_mensagem_de_erro_quando_segundo_valor_for_zero() {
        when(leitor.ler()).thenReturn(5.0).thenReturn(0.0).thenReturn(5.0);
        String mensagemEsperada = "valor invalido";

        calculadora.calcular();

        Mockito.verify(impressora).imprimirString(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }
}
