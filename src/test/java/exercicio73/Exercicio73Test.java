package exercicio73;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio73Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Calculadora calculadora;

    @Test
    void deve_calcular_a_media_de_salario_da_populacao() {
        Mockito.when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("nao");
        Mockito.when(leitor.lerDouble()).thenReturn(5605.0).thenReturn(1200.0);
        var mediaEsperada = 1.506;

        calculadora.calcular();

        Mockito.verify(impressora).imprimirMediaDeSalario(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }
    @Test
    void Deve_calcular_media_de_filhos_da_populacao(){
        Mockito.when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("nao");
//    Asse
    }
}
