package exercicio85;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio85Test {
    @Captor
    private ArgumentCaptor<List<Double>> argumentCaptor;

    @Mock
    Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Temperatura temperatura;

    @Test
    void deve_informar_ah_menor_temperatura_ano() {
        Mockito.when(leitor.ler()).thenReturn(33d).thenReturn(29d).thenReturn(26d).thenReturn(24d)
                .thenReturn(23d).thenReturn(27d).thenReturn(40d).thenReturn(11d).thenReturn(32d)
                .thenReturn(25d).thenReturn(10d).thenReturn(14d).thenReturn(19d).thenReturn(20d)
                .thenReturn(17d).thenReturn(31d).thenReturn(23d).thenReturn(29d).thenReturn(32d);

        List<Double> temperaturaEsperada = Arrays.asList(10d);

        temperatura.calcular();

        Mockito.verify(impressora, Mockito.times(4)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(temperaturaEsperada, argumentCaptor.getAllValues().get(0));
    }

    @Test
    void deve_informar_ah_maior_temperatura_do_ano() {
        Mockito.when(leitor.ler()).thenReturn(33d).thenReturn(29d).thenReturn(26d).thenReturn(24d)
                .thenReturn(23d).thenReturn(27d).thenReturn(40d).thenReturn(11d).thenReturn(32d)
                .thenReturn(25d).thenReturn(10d).thenReturn(14d).thenReturn(19d).thenReturn(20d)
                .thenReturn(17d).thenReturn(31d).thenReturn(23d).thenReturn(29d).thenReturn(32d);
        List<Double> temperaturaEsperada = Arrays.asList(40d);

        temperatura.calcular();

        Mockito.verify(impressora, Mockito.times(4)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(temperaturaEsperada, argumentCaptor.getAllValues().get(1));

    }

    @Test
    void deve_imprimir_ah_media_da_temperatura_anual() {
        Mockito.when(leitor.ler()).thenReturn(33d).thenReturn(29d).thenReturn(26d).thenReturn(24d)
                .thenReturn(23d).thenReturn(27d).thenReturn(40d).thenReturn(11d).thenReturn(32d)
                .thenReturn(25d).thenReturn(10d).thenReturn(14d).thenReturn(19d).thenReturn(20d)
                .thenReturn(17d).thenReturn(31d).thenReturn(23d).thenReturn(29d).thenReturn(32d);
        List<Double> mediaEsperada = Arrays.asList(31.61);


        temperatura.calcular();

        Mockito.verify(impressora, Mockito.times(4)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getAllValues().get(2));
    }

    @Test
    void deve_imprimir_quantas_vezes_no_ano_ah_temperatura_foi_menor_que_a_media_anual() {
        Mockito.when(leitor.ler()).thenReturn(33d).thenReturn(29d).thenReturn(26d).thenReturn(24d)
                .thenReturn(23d).thenReturn(27d).thenReturn(40d).thenReturn(11d).thenReturn(32d)
                .thenReturn(25d).thenReturn(10d).thenReturn(14d).thenReturn(19d).thenReturn(20d)
                .thenReturn(17d).thenReturn(31d).thenReturn(23d).thenReturn(29d).thenReturn(32d);
        List<Double> quantidadeEsperada = Arrays.asList(15d);

        temperatura.calcular();

        Mockito.verify(impressora, Mockito.times(4)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(quantidadeEsperada, argumentCaptor.getAllValues().get(3));
    }
}