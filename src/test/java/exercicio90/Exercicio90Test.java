package exercicio90;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio90Test {
    @Captor
    private ArgumentCaptor<List<Integer>> argumentCaptorDeLista;
    @Captor
    ArgumentCaptor<Integer> argumentCaptorDeInt;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    private Vetor vetor;

    @Test
    void deve_imprimir_o_vetor() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20)
                .thenReturn(21).thenReturn(22).thenReturn(23).thenReturn(24).thenReturn(25)
                .thenReturn(26).thenReturn(27).thenReturn(28).thenReturn(29).thenReturn(30);
        List<Integer> vetorEsperado = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19
                , 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);

        vetor.calcular();

        Mockito.verify(impressora).imprimirList(argumentCaptorDeLista.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptorDeLista.getValue());
    }

    @Test
    void deve_imprimir_ah_quantidade_de_vezes_que_um_numero_se_repetiu_dentro_do_vetor() {
        var numerosEspecionado = 123;
        Mockito.when(leitor.ler())
                .thenReturn(123).thenReturn(123).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(123).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(123).thenReturn(19).thenReturn(20)
                .thenReturn(21).thenReturn(22).thenReturn(23).thenReturn(24).thenReturn(25)
                .thenReturn(26).thenReturn(27).thenReturn(28).thenReturn(123).thenReturn(30)
                .thenReturn(numerosEspecionado);
        var quantidadeDeVezesQueOhNumerosRepetiuEsperado = 5;

        vetor.calcular();

        Mockito.verify(impressora).imprimirInt(argumentCaptorDeInt.capture());
        Assertions.assertEquals(quantidadeDeVezesQueOhNumerosRepetiuEsperado, argumentCaptorDeInt.getValue());
    }
}
