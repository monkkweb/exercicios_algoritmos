import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class exercicio41Test {

    private CalculadoraDeNota calculadora;

    @BeforeEach
    public void init() {
        calculadora = new CalculadoraDeNota();
    }

    @Test
    public void deve_calcular_media_dos_exercicios() {
        var notaUm = 6;
        var notaDois = 5;
        var notaTres = 7;
        var mediaEsperada = (notaUm + notaDois + notaTres) / 3;

        Media media = calculadora.mediaDeAproveitamento(notaUm, notaDois, notaTres);

        Assertions.assertEquals(mediaEsperada, media.getMediaDosExercicios());
    }

    @Test
    public void deve_calcular_media_de_aproveitamento() {
        var notaUm = 6;
        var notaDois = 5;
        var notaTres = 7;
        var mediaEsperada = (notaUm + notaDois + notaTres) / 3;

        Media media = calculadora.mediaDeAproveitamento(notaUm, notaDois, notaTres);

        Assertions.assertEquals(mediaEsperada, media.getMediaDosExercicios());
    }

    @Test
    public void deve_conceituar_a_media_de_aproveitamento() {
        var conceitoEsperado = "C";

        var conceito = new Conceito();
        var resultadoDoConceito = conceito.conceitos(6.14);

        Assertions.assertEquals(conceitoEsperado, resultadoDoConceito);
    }

    @Test
    public void nota_um_nao_tem_que_ser_menor_que_zero() {
        var notaUm = -4;
        var notaDois = -2;
        var notaTres = -3;
        var mensagemEsperada = "Nota não pode ser menor que zero";

        var excecao = Assertions.assertThrows(RuntimeException.class, () -> calculadora.mediaDeAproveitamento(notaUm, notaDois, notaTres));

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }

    @Test
    public void nota_dois_nao_tem_que_ser_menor_que_zero() {
        var notaUm = 1;
        var notaDois = -2;
        var notaTres = 2;
        var mensagemEsperada = "Nota não pode ser menor que zero";


        var excecao = Assertions.assertThrows(RuntimeException.class, () -> calculadora.mediaDeAproveitamento(notaUm, notaDois, notaTres));

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }

    @Test
    public void nota_tres_nao_tem_que_ser_menor_que_zero() {
        var notaUm = 1;
        var notaDois = 2;
        var notaTres = -2;
        var mensagemEsperada = "Nota não pode ser menor que zero";

        CalculadoraDeNota calculadora = new CalculadoraDeNota();

        var excecao = Assertions.assertThrows(RuntimeException.class, () -> calculadora.mediaDeAproveitamento(notaUm, notaDois, notaTres));

        Assertions.assertEquals(mensagemEsperada, excecao.getMessage());
    }
}