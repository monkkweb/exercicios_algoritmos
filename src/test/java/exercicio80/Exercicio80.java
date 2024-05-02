package exercicio80;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class Exercicio80 {
    @Captor
    ArgumentCaptor<Integer> argumentCaptorInt;
    @Captor
    ArgumentCaptor<String> argumentCaptorSting;
    @Mock
    private Impressora impressora;
    @Mock
    private Leitor leitor;
    @InjectMocks
    Vetor vetor;

    @Test
    void deve_ler_posicoes_do_vetor_Q_aceitando_apenas_numeros_positivos() {
        when(leitor.ler()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5).thenReturn(6).thenReturn(7).thenReturn
                        (8).thenReturn(9).thenReturn(10).thenReturn(11).thenReturn(12).thenReturn(13).thenReturn(14).thenReturn(15)
                .thenReturn(16).thenReturn(17).thenReturn(18).thenReturn(19).thenReturn(20);
        int posicoesEsperadas = 19;

        vetor.calcular();

                Mockito.verify(impressora, times(4)).imprimirInt(argumentCaptorInt.capture());
        Assertions.assertEquals(posicoesEsperadas, argumentCaptorInt.getAllValues().get(1));
    }

    @Test
    void deve_imprimir_o_maior_valor_do_vetor_Q() {
        when(leitor.ler()).thenReturn(2).thenReturn(9).thenReturn(5);
        var valorEsperado = 9;

        vetor.calcular();

        Mockito.verify(impressora, times(4)).imprimirInt(argumentCaptorInt.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptorInt.getAllValues().get(0));
    }

    @Test
    void deve_imprimir_posicao_do_maior_numero_do_vetor_Q(){
        when(leitor.ler()).thenReturn(2).thenReturn(9).thenReturn(5);
        var valorEsperado = 1;

        vetor.calcular();

        Mockito.verify(impressora, times(4)).imprimirInt(argumentCaptorInt.capture());
        Assertions.assertEquals(valorEsperado, argumentCaptorInt.getAllValues().get(1));
    }

    @Test
    void deve_transmitir_mensagem_de_erro_caso_atribua_ao_vetor_Q_algum_numero_negativo() {
        when(leitor.ler()).thenReturn(5).thenReturn(-5);
        String fraseEsperada = "Só é aceito numeros positivos";

        vetor.calcular();

        Mockito.verify(impressora).imprimirString(argumentCaptorSting.capture());
        Assertions.assertEquals(fraseEsperada, argumentCaptorSting.getValue());
    }
    @Test
    void deve_imprimir_menor_numero_do_vetor_Q(){
        when(leitor.ler()).thenReturn(50).thenReturn(100);
        var menorNumeroEsperdado = 50;

        vetor.calcular();

        verify(impressora, times(4)).imprimirInt(argumentCaptorInt.capture());
        Assertions.assertEquals(menorNumeroEsperdado, argumentCaptorInt.getAllValues().get(2));
    }
    @Test
    void deve_imprimr_posicao_do_menor_numero_do_vetor(){
        when(leitor.ler()).thenReturn(10).thenReturn(5).thenReturn(50);
        var posicaoEsperada= 1;

        vetor.calcular();

        verify(impressora,times(4)).imprimirInt(argumentCaptorInt.capture());
        Assertions.assertEquals(posicaoEsperada, argumentCaptorInt.getAllValues().get(3));
    }
}
