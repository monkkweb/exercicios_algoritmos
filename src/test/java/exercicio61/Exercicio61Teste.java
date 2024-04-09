package exercicio61;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio61Teste {
    @Mock
    Impressora impressora;
    @Mock
    Leitor leitor;
    @InjectMocks
    CalculadoraDeMedia calculculadoraDeMedia;
    @Captor
    ArgumentCaptor<Double> argumentCaptor;

    @Test
    void deve_calcular_media_aritimetica() {
        Mockito.when(leitor.ler()).thenReturn(5.0).thenReturn(10.0);
        double mediaEsperada = 9.5;

        calculculadoraDeMedia.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }
}
