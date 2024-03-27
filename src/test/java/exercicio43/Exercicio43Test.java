package exercicio43;

import lombok.var;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Exercicio43Test {

    private CalculadoraDeTriangulo calcular;

    @BeforeEach
    public void init() {
        calcular = new CalculadoraDeTriangulo();
    }

    @ParameterizedTest(name = "Triangulos equiláteros")
    @CsvSource({"4,4,4", "3,3,3", "5,5,5"})
    public void eh_triangulo_equilatero(int ladoA, int ladoB, int ladoC) {
        var mensagemEsperada = "Triangulo equilátero";

        Assert.assertEquals(mensagemEsperada, calcular.mensagem(ladoA, ladoB, ladoC));
    }

    @ParameterizedTest(name = "Triangulos isósceles")
    @CsvSource({"5,3,3", "6,4,4", "7,5,5"})
    public void eh_triangulo_isosceles(int ladoA, int ladoB, int ladoC) {
        var mesagemEsperada = "Triangulo isósceles";

        Assert.assertEquals(mesagemEsperada, calcular.mensagem(ladoA, ladoB, ladoC));
    }

    @ParameterizedTest(name = "Triangulos isósceles")
    @CsvSource({"3,4,5", "4,5,6", "7,8,9"})
    public void eh_triangulo_escaleno(int ladoA, int ladoB, int ladoC) {
        var mensgemEperada = "Triangulo escaleno";

        Assert.assertEquals(mensgemEperada, calcular.mensagem(ladoA, ladoB, ladoC));
    }

    @ParameterizedTest(name = "Triangulos isósceles")
    @CsvSource({"0,0,0"})
    public void nao_eh_triangulo(int ladoA, int ladoB, int ladoC) {
        var mensagemEsperada = "Não é triangulo";

        Assert.assertEquals(mensagemEsperada, calcular.mensagem(ladoA, ladoB, ladoC));
    }
}