package exercicio77;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio77Test {

    @Test
    void deve_imprimir_resultado_do_vetor_apos_ah_modificacao_pedida() {
        int[] vetorEsperado = {5, 7, 4, 1, 7, 8, 3, 6};

        Vetor vetor = new Vetor();

        Assertions.assertArrayEquals(vetorEsperado, vetor.calcular());
    }
}
