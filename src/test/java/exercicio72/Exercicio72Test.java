package exercicio72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio72Test {
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Calculadora calculadora;


    @Test
    void deve_ler_o_maior_preco_lido() {
        Mockito.when(leitor.lerInt()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10).thenReturn(11)
                .thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15);

        Mockito.when(leitor.lerDouble()).thenReturn(1d).thenReturn(2d).thenReturn(3d).thenReturn(4d).thenReturn(5d)
                .thenReturn(6d).thenReturn(7d).thenReturn(8d).thenReturn(9d).thenReturn(10d).thenReturn(11d)
                .thenReturn(12d).thenReturn(13d).thenReturn(14d).thenReturn(15d);
        var maiorPrecoLido = 15;

        calculadora.calcular();

        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(maiorPrecoLido, argumentCaptor.getAllValues().get(1));
    }

    @Test
    void deve_calcular_a_media_dos_produtos() {
        Mockito.when(leitor.lerInt()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10).thenReturn(11)
                .thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15);

        Mockito.when(leitor.lerDouble()).thenReturn(1d).thenReturn(2d).thenReturn(3d).thenReturn(4d).thenReturn(5d)
                .thenReturn(6d).thenReturn(7d).thenReturn(8d).thenReturn(9d).thenReturn(10d).thenReturn(11d)
                .thenReturn(12d).thenReturn(13d).thenReturn(14d).thenReturn(15d);
        var mediaEsperada = 8;

        calculadora.calcular();

        Mockito.verify(impressora,Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getAllValues().get(0));
    }
}
