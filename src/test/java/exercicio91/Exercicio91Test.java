package exercicio91;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio91Test {
    @Captor
    private ArgumentCaptor<List<Integer>> argumentCaptorDeList;
    @Captor
    ArgumentCaptor<String> argumentCaptorDeString;
    @Mock
    private Leitor leitor;
    @Mock
    private Impressora impressora;
    @InjectMocks
    Vetor vetor;

    @Test
    void deve_imprimir_vetor_com_50_valores() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20)
                .thenReturn(21).thenReturn(22).thenReturn(23).thenReturn(24).thenReturn(25)
                .thenReturn(26).thenReturn(27).thenReturn(28).thenReturn(29).thenReturn(30)
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20);
        List<Integer> vetorEsperado = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        vetor.calcular();

        Mockito.verify(impressora, Mockito.times(2)).imprimirLista(argumentCaptorDeList.capture());
        Assertions.assertEquals(vetorEsperado, argumentCaptorDeList.getAllValues().get(0));
    }

    @Test
    void deve_imprimir_em_qual_posicao_se_encontra_os_numeros_repetidos_dentro_do_vetor() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20)
                .thenReturn(21).thenReturn(22).thenReturn(23).thenReturn(24).thenReturn(25)
                .thenReturn(26).thenReturn(27).thenReturn(28).thenReturn(29).thenReturn(30)
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20);
        List<Integer> posicoesEsperadas = Arrays.asList(30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
                46, 47, 48, 49);

        vetor.calcular();

        Mockito.verify(impressora,Mockito.times(2)).imprimirLista(argumentCaptorDeList.capture());
        Assertions.assertEquals(posicoesEsperadas, argumentCaptorDeList.getAllValues().get(1));
    }

    @Test
    void deve_imprimir_mensagem_caso_tenha_numero_repetido() {
        Mockito.when(leitor.ler())
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20)
                .thenReturn(21).thenReturn(22).thenReturn(23).thenReturn(24).thenReturn(25)
                .thenReturn(26).thenReturn(27).thenReturn(28).thenReturn(29).thenReturn(30)
                .thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5)
                .thenReturn(6).thenReturn(7).thenReturn(8).thenReturn(9).thenReturn(10)
                .thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20);
        var mensagemEsperada = "Tem numero repetido.";

        vetor.calcular();

        Mockito.verify(impressora).imprimirSTring(argumentCaptorDeString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorDeString.getValue());
    }

    @Test
    void deve_imprimir_mensagem_caso_nao_tenha_numero_repetido() {
        Mockito.when(leitor.ler())
                .thenReturn(1111991).thenReturn(2111111).thenReturn(3111111).thenReturn(1111114).thenReturn(111115)
                .thenReturn(1111111116).thenReturn(71111111).thenReturn(11118).thenReturn(11119).thenReturn(101111)
                .thenReturn(111111999).thenReturn(11111112).thenReturn(11113).thenReturn(11114).thenReturn(11115)
                .thenReturn(111116).thenReturn(1111117).thenReturn(18111).thenReturn(1111119).thenReturn(21110)
                .thenReturn(211111).thenReturn(221111).thenReturn(21113).thenReturn(211114).thenReturn(21115)
                .thenReturn(21111116).thenReturn(119111).thenReturn(211118).thenReturn(211119).thenReturn(111130)
                .thenReturn(121).thenReturn(111).thenReturn(311).thenReturn(1914).thenReturn(1915)
                .thenReturn(61).thenReturn(71).thenReturn(128).thenReturn(91).thenReturn(110)
                .thenReturn(19911).thenReturn(1921).thenReturn(131).thenReturn(114).thenReturn(115)
                .thenReturn(116).thenReturn(117).thenReturn(118).thenReturn(119).thenReturn(210);
        var mensagemEsperada = "Não tem numero repetido.";

        vetor.calcular();

        Mockito.verify(impressora).imprimirSTring(argumentCaptorDeString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorDeString.getValue());
    }
}