package exercicio89;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio89Test {
    @Captor
    ArgumentCaptor<List<Integer>> argumentCaptorDeLista;
    @Captor
    ArgumentCaptor<Integer> argumentCaptorDeInt;
    @Mock
    Leitor leitor;
    @Mock
    Impressora impressora;
    @InjectMocks
    Vetor vetor;

    @Test
    void deve_exibir_vetorUm() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15);
        List vetorEsperado = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        vetor.calcular();

        Mockito.verify(impressora, Mockito.times(2)).imprimirLista(argumentCaptorDeLista.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptorDeLista.getAllValues().get(0));
    }

    @Test
    void deve_exibir_vertorDois() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15);
        List vetorEsperado = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        vetor.calcular();

        Mockito.verify(impressora, Mockito.times(2)).imprimirLista(argumentCaptorDeLista.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptorDeLista.getAllValues().get(1));
    }

    @Test
    void deve_imprimir_quantos_numeros_sao_iguais_eh_estao_na_mesma_posicao_entre_vetorUm_eh_vetorDois() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15);
        var quantidadeDeNumerosRespetidosEsperados = 15;

        vetor.calcular();

        Mockito.verify(impressora).imprimirInt(argumentCaptorDeInt.capture());
        Assertions.assertEquals(quantidadeDeNumerosRespetidosEsperados, argumentCaptorDeInt.getValue());
    }
}
