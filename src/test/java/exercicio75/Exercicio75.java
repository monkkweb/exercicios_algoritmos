package exercicio75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicio75 {

    @Test
    void deve_imprimir_sequencia_do_um_ao_dez_dez_vezes() {
        List<List<Integer>> sequenciaNumericaEsperada = Arrays.asList(Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Arrays.asList(3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Arrays.asList(6, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(7, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Arrays.asList(8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        CalculadoraDeSequencia calculadoraDeSequencia = new CalculadoraDeSequencia();

        Assertions.assertEquals(sequenciaNumericaEsperada, calculadoraDeSequencia.calcular());
    }
}
