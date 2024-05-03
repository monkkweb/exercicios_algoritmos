package exercicio67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio67Test {

    @Test
    void deve_calcular_media_entre_quinze_e_cem() {
        var mediaEsperada = 57.5;

        Calculadora calculadora = new Calculadora();

        Assertions.assertEquals(mediaEsperada, calculadora.calcular());
    }
}
