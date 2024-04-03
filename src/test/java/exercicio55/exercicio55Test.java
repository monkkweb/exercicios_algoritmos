package exercicio55;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class exercicio55Test {
    @Test
    void deve_calcular_tabuada_do_oito() {
        int[] numeroEsperado = {8, 16, 24, 32, 40, 48, 56, 64, 72, 80};

        Calculadora calculadora = new Calculadora();

        Assertions.assertArrayEquals(numeroEsperado, calculadora.calcular());
    }
}
