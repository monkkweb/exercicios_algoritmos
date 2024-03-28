package exercicio48;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class Exercici48Teste {
    @Mock
    public Impressora IMPRESSORA;
    @Mock
    public Leitor LEITOR;
    @InjectMocks
    private Calculadora calculadora;
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Captor
    ArgumentCaptor<String> argumentCaptorString;

    @Test
    void deve_calcular_media_do_aluno_quando_a_primeira_e_segunda_nota_forem_maior_que_zero() {
        Mockito.when(LEITOR.ler()).thenReturn(5.0).thenReturn(5.0);
        double mediaEsperada = 5;

        calculadora.calcularMedia();

        Mockito.verify(IMPRESSORA).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void quando_primeira_nota_for_menor_que_zero_entao_imprima_nota_invalida() {
        Mockito.when(LEITOR.ler()).thenReturn(-2.0).thenReturn(5.0).thenReturn(5.0);
        String mensagemEsperada = "nota um invalida";

        calculadora.calcularMedia();

        Mockito.verify(IMPRESSORA).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }

    @Test
    void quando_primeira_nota_for_valida_na_segunda_vez_entao_imprime_media_do_aluno() {
        Mockito.when(LEITOR.ler()).thenReturn(-2.0).thenReturn(5.0).thenReturn(5.0);
        double mediaEsperada = 5;

        calculadora.calcularMedia();

        Mockito.verify(IMPRESSORA).imprimir(argumentCaptor.capture());

        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }
}
