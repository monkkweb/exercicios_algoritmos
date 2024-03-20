import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class exercicio41Test {

    private CalculadoraDeNota calculadora;

    @BeforeEach
    public void init() {
        calculadora = new CalculadoraDeNota();
    }

    @ParameterizedTest(name = "media dos exercicios")
    @CsvSource({"6,5,7,6", "0,0,0,0"})
    public void deve_calcular_media_dos_exercicios(int notaUm, int notaDois, int notaTres, double mediaEsperada) {
        Media media = calculadora.calcular(notaUm, notaDois, notaTres);

        Assertions.assertEquals(mediaEsperada, media.getMediaDosExercicios());
    }

    @ParameterizedTest(name = "media de aproveitamento")
    @CsvSource({"6,5,7,6.14f", "0,0,0,0", "10,10,10,10"})
    public void deve_calcular_media_de_aproveitamento(int notaUm, int notaDois, int notaTres, double mediaEsperada) {
        Media media = calculadora.calcular(notaUm, notaDois, notaTres);

        Assertions.assertEquals(mediaEsperada, media.getMediaDeAproveitamento(), 0.02);
    }

    @ParameterizedTest(name = "quando media for {0} então conceito é {1}")
    @CsvSource({"5, D", "6.14, C", "8, B", "10, A"})
    public void deve_conceituar_a_media_de_aproveitamento(double media, String conceitoEsperado) {
        var conceito = new Conceito(media);

        Assertions.assertEquals(conceitoEsperado, conceito.getLetra());
    }

    @ParameterizedTest(name = "quando nota for {0}, {1} e {2} então exibe mensagem de erro")
    @CsvSource({"-4, 2, 3", "1, -2, 2", "1, 2, -2"})
    public void nota_nao_pode_ser_menor_que_zero(int notaUm, int notaDois, int notaTres) {
        var mensagemEsperada = "Nota não pode ser menor que zero";

        Executable executable = () -> calculadora.calcular(notaUm, notaDois, notaTres);
        var excecao = Assertions.assertThrows(RuntimeException.class, executable);

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }

    @Test
    public void media_tem_que_ter_conceito() {
        int notaUm = 4;
        int NotaDois = 5;
        int notaTres = 8;

        var media = calculadora.calcular(notaUm, NotaDois, notaTres);

        Assertions.assertNotNull(media.getConceito());
    }
}
