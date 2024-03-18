import lombok.var;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class exercicio41Test {
    @Test
    public void deve_calcular_media_dos_exercicios() {
        var notaEsperada = 6;
        var notaUm = 6;
        var notaDois = 5;
        var notaTres = 7;

        var calculadora = new CalculadoraDeNota();
        var resultado = calculadora.mediaDosExercicios(notaUm, notaDois, notaTres);

        Assertions.assertEquals(notaEsperada, resultado);
    }

    @Test
    public void deve_calcular_media_de_aproveitamento() {
        var notaEsperada = 6.14f;
        var notaUm = 6;
        var notaDois = 5;
        var notaTres = 7;

        var calculadora = new CalculadoraDeNota();
        var resultado = calculadora.mediaDeAproveitamento(notaUm, notaDois, notaTres);

        Assertions.assertEquals(notaEsperada, resultado, 0.02);
    }

    @Test
    public void deve_conceituar_a_media_de_aproveitamento() {
        var conceitoEsperado = "C";

        var conceito = new Conceito();
        var resultado = conceito.conceitos(6.14);

        Assertions.assertEquals(conceitoEsperado, resultado);
    }
}