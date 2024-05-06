package exercicio48;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class Exercici48Teste {
    @Captor
    ArgumentCaptor<String> argumentCaptorString;
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Mock
    public Impressora impressora;
    @Mock
    public Leitor leitor;
    @InjectMocks
    private Calculadora calculadora;

    @ParameterizedTest(name = "media = {2}")
    @CsvSource({"5.0, 5.0, 5.0", "4.0, 5.0, 4.5"})
    void deve_calcular_media_do_aluno_quando_a_primeira_e_segunda_nota_forem_maior_que_zero(double primeiraNota,
                                                                                            double segundaNota,
                                                                                            double mediaEsperada) {
        Mockito.when(leitor.lerDouble()).thenReturn(primeiraNota).thenReturn(segundaNota);
        Mockito.when(leitor.lerString()).thenReturn("não");

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void quando_primeira_nota_for_menor_que_zero_entao_imprima_primeira_nota_invalida() {
        Mockito.when(leitor.lerDouble()).thenReturn(-2.0).thenReturn(5.0).thenReturn(5.0);
        var mensagemEsperada = "primeira nota invalida";
        Mockito.when(leitor.lerString()).thenReturn("não");

        calculadora.calcularMedia();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getAllValues().get(0));
    }

    @Test
    void quando_primeira_nota_for_maior_que_dez_imprima_primeira_nota_invalida() {
        var mensagemEsperada = "primeira nota invalida";
        Mockito.when(leitor.lerDouble()).thenReturn(11.0).thenReturn(7.0);
        Mockito.when(leitor.lerString()).thenReturn("não");

        calculadora.calcularMedia();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getAllValues().get(0));
    }

    @Test
    void quando_primeira_nota_for_valida_na_segunda_vez_entao_imprime_media_do_aluno() {
        Mockito.when(leitor.lerDouble()).thenReturn(-2.0).thenReturn(5.0).thenReturn(5.0);
        Mockito.when(leitor.lerString()).thenReturn("não");
        var mediaEsperada = 5;

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void quando_segunda_nota_for_menor_que_zero_entao_imprima_segunda_nota_invalida() {
        Mockito.when(leitor.lerDouble()).thenReturn(5.0).thenReturn(-2.0).thenReturn(4.0);
        Mockito.when(leitor.lerString()).thenReturn("não");
        var mensagemEsperada = "segunda nota invalida";

        calculadora.calcularMedia();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getAllValues().get(0));
    }

    @Test
    void quando_segunda_nota_for_maior_que_dez_imprima_segunda_nota_invalida() {
        Mockito.when(leitor.lerDouble()).thenReturn(6.0).thenReturn(12.0).thenReturn(6.0);
        Mockito.when(leitor.lerString()).thenReturn("não");
        var mensagemEsperada = "segunda nota invalida";

        calculadora.calcularMedia();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getAllValues().get(0));
    }

    @Test
    void quando_segunda_nota_for_valida_na_segunda_vez_entao_imprime_media_do_aluno() {
        Mockito.when(leitor.lerDouble()).thenReturn(6.0).thenReturn(7.0);
        Mockito.when(leitor.lerString()).thenReturn("não");
        var mediaEsperada = 6.5;

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void deve_calcular_media_novamente_quando_comando_for_sim() {
        Mockito.when(leitor.lerDouble()).thenReturn(7.0).thenReturn(9.0).thenReturn(1.0).thenReturn(9.0);
        Mockito.when(leitor.lerString()).thenReturn("sim").thenReturn("não");
        var mediaEsperado = 5.0;

        calculadora.calcularMedia();

        Mockito.verify(impressora, Mockito.times(2)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperado, argumentCaptor.getValue());
    }

    @Test
    void quando_comando_for_nao_termina_codigo() {
        Mockito.when(leitor.lerDouble()).thenReturn(5.0).thenReturn(6.0);
        Mockito.when(leitor.lerString()).thenReturn("sim").thenReturn("não");

        calculadora.calcularMedia();

        Mockito.verify(leitor, Mockito.times(2)).lerString();
    }
}