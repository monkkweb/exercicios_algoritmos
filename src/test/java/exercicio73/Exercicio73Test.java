package exercicio73;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("nao");
        when(leitor.lerDouble()).thenReturn(3500d).thenReturn(1200d).thenReturn(300d);
        var mediaEsperada = 1325;

        calculadora.calcular();

        verify(impressora, Mockito.times(4)).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getAllValues().get(0));
    }

    @Test
    void deve_calcular_media_de_filhos_da_populacao() {
        when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("nao");
        when(leitor.lerInt()).thenReturn(2).thenReturn(2).thenReturn(4).thenReturn(4);
        var mediaEsperada = 3;

        calculadora.calcular();

        verify(impressora, Mockito.times(4)).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getAllValues().get(1));
    }

    @Test
    void deve_mostrar_maior_salario_dos_habitantes() {
        when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("nao");
        when(leitor.lerDouble()).thenReturn(10000d).thenReturn(1200d).thenReturn(300d);
        var maiorSalarioEsperado = 10000;

        calculadora.calcular();

        verify(impressora, Mockito.times(4)).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(maiorSalarioEsperado, argumentCaptor.getAllValues().get(2));
    }

    @Test
    void deve_calcular_percentual_de_pessoas_que_tem_salario_ah_baixo_de_cento_e_cinquenta() {
        when(leitor.lerString()).thenReturn("sim").thenReturn("sim").thenReturn("sim").thenReturn("nao");
        when(leitor.lerDouble()).thenReturn(10000d).thenReturn(1200d).thenReturn(120d).thenReturn(140d);
        var percentualEsperado = 50;

        calculadora.calcular();

        verify(impressora, Mockito.times(4)).imprimirDouble(argumentCaptor.capture());
        Assertions.assertEquals(percentualEsperado, argumentCaptor.getAllValues().get(3));
    }

    @Test
    void deve_exibir_mensagem_de_erro_sobre_salario_negativo() {
        when(leitor.lerDouble()).thenReturn(-50d);
        var mensagemDeErro = "Não pode salario menor que zero.";

        var excecao = Assertions.assertThrows(RuntimeException.class, () -> calculadora.calcular());

        Assertions.assertEquals(mensagemDeErro, excecao.getMessage());
    }

}
