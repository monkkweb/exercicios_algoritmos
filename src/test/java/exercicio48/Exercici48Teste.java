package exercicio48;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class Exercici48Teste {
    @Mock
    public Impressora impressora;
    @Mock
    public Leitor leitor;
    @InjectMocks
    private Calculadora calculadora;
    @Captor
    ArgumentCaptor<Double> argumentCaptor;
    @Captor
    ArgumentCaptor<String> argumentCaptorString;

    @ParameterizedTest(name = "media = {2}")
    @CsvSource({"5.0, 5.0, 5.0", "4.0, 5.0, 4.5"})
    void deve_calcular_media_do_aluno_quando_a_primeira_e_segunda_nota_forem_maior_que_zero(double primeiraNota,
                                                                                            double segundaNota,
                                                                                            double mediaEsperada) {
        Mockito.when(leitor.ler()).thenReturn(primeiraNota).thenReturn(segundaNota);

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void quando_primeira_nota_for_menor_que_zero_entao_imprima_primeira_nota_invalida() {
        Mockito.when(leitor.ler()).thenReturn(-2.0).thenReturn(5.0).thenReturn(5.0);
        String mensagemEsperada = "primeira nota invalida";

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }

    @Test
    void quando_primeira_nota_for_maior_que_dez_imprima_primeira_nota_invalida() {
        var mensagemEsperada = "primeira nota invalida";
        Mockito.when(leitor.ler()).thenReturn(11.0).thenReturn(7.0);

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }

    @Test
    void quando_primeira_nota_for_valida_na_segunda_vez_entao_imprime_media_do_aluno() {
        Mockito.when(leitor.ler()).thenReturn(-2.0).thenReturn(5.0).thenReturn(5.0);
        double mediaEsperada = 5;

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void quando_segunda_nota_for_menor_que_zero_entao_imprima_segunda_nota_invalida() {
        Mockito.when(leitor.ler()).thenReturn(5.0).thenReturn(-2.0).thenReturn(4.0);
        var mensagemEsperada = "segunda nota invalida";

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }

    @Test
    void quando_segunda_nota_for_maior_que_dez_imprima_segunda_nota_invalida() {
        Mockito.when(leitor.ler()).thenReturn(6.0).thenReturn(12.0).thenReturn(6.0);
        var mensagemEsperada = "segunda nota invalida";

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(mensagemEsperada, argumentCaptorString.getValue());
    }

    @Test
    void quando_segunda_nota_for_valida_na_segunda_vez_entao_imprime_media_do_aluno() {
        Mockito.when(leitor.ler()).thenReturn(6.0).thenReturn(7.0);
        var mediaEsperada = 6.5;

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(mediaEsperada, argumentCaptor.getValue());
    }

    @Test
    void enquanto_comando_for_sim_deve_calcular_nova_media() {
        Mockito.when(leitor.ler()).thenReturn("sim");
        var comandoEsperado = "sim";

        calculadora.calcularMedia();

        Mockito.verify(impressora).imprimir(argumentCaptorString.capture());
        Assertions.assertEquals(comandoEsperado, argumentCaptorString.getValue());
    }

}