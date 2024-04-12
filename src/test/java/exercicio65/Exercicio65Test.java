package exercicio65;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio65Test {
    @Captor
    ArgumentCaptor<Integer> argumentCaptorInt;
    @Captor
    ArgumentCaptor<String> argumentCaptorString;
    @Mock
    Impressora impressora;
    @Mock
    Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_somoar_numeros_inteiro_do_valor_um_ao_valor_dois() {
        Mockito.when(leitor.ler()).thenReturn(1).thenReturn(5);
        var numeroEsperado = 15;

        calculadora.calcular();

        Mockito.verify(impressora).imprimirInt(argumentCaptorInt.capture());
        Assertions.assertEquals(numeroEsperado, argumentCaptorInt.getValue());
    }
    @Test
    void segundo_numero_nao_pode_ser_menor_que_primeiro_numeoro(){
        Mockito.when(leitor.ler()).thenReturn(5).thenReturn(2);
        var mensagemEsperada = "SEGUNDO VALOR TEM QUE SER MAIOR!!!";

        calculadora.calcular();

        Mockito.verify(impressora).imprimirString(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }
}
