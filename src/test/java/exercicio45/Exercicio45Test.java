package exercicio45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio45Test {

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
    public void enquanto_segundo_numero_for_zero_repete_segundo_valor() {
        Mockito.when(leitor.ler()).thenReturn(4.0).thenReturn(0.0).thenReturn(4.0);
        double valorEsperado = 1;

        calculadora.calcular();

        Mockito.verify(impressora).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptor.getValue());
    }

    @Test
    public void deve_retornar_mensagem_de_erro_quando_segundo_valor_for_zero() {
        Mockito.when(leitor.ler()).thenReturn(4.0).thenReturn(0.0).thenReturn(4.0);
        String mensagemEsperada = "Valor invalido";

        calculadora.calcular();

        Mockito.verify(impressora).imprimirString(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }
}