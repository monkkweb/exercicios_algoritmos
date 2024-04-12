package exercicio67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio67Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @InjectMocks
    Calculadora calculadora;
    @Mock
    private Impressora impressora;

    @Test
    void deve_calcular_calcular_media_entre_quinze_e_cem() {
        var mediaEsperada = 57.5;

        calculadora.calcular();
        
        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }
}
