package exercicio77;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio77Test {

    @Test
    void deve_mostrar_resultado_do_vetor_de_valor_cinco() {
        var vetor = new Vetor();
        int[] valorDoVetorEsperado = {5};

        int [] resultado = vetor.calcular();

        Assertions.assertArrayEquals(valorDoVetorEsperado, resultado);
    }
}
