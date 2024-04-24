package exercicio74;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicio74Test {
    @Test
    void deve_fazer_ah_taboada_do_um_ao_dez() {
        List<List<Integer>> tabuadaEsperada = Arrays.asList(Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(2, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20), Arrays.asList(3, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30),
                Arrays.asList(4, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40), Arrays.asList(5, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50),
                Arrays.asList(6, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60), Arrays.asList(7, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70),
                Arrays.asList(8, 8, 16, 24, 32, 40, 48, 56, 64, 72, 80), Arrays.asList(9, 9, 18, 27, 36, 45, 54, 63, 72, 81, 90),
                Arrays.asList(10, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100));

        Calculadora calculadora = new Calculadora();

        Assertions.assertEquals(tabuadaEsperada, calculadora.calcular());
    }
}
