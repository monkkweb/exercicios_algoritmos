package exercicio75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicio75 {

    @Test
    void deve_calcular_a_ultima_sequencias_numericas() {
        List<Integer> sequenciaNumericaEsperada = Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        CalculadoraDeSequencia calculadoraDeSequencia = new CalculadoraDeSequencia();

        Assertions.assertEquals(sequenciaNumericaEsperada, calculadoraDeSequencia.calcular());
    }
    //todo: colocar "1,12345678910..."
}
