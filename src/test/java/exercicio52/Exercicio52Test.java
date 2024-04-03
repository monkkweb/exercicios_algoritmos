package exercicio52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio52Test {

    @Test
    public void os_dez_primeiros_numeros_inteiros_maior_que_cem() {

        int[] numerosInteirosEsperados = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};

        Numeros numeros = new Numeros();

        Assertions.assertArrayEquals(numerosInteirosEsperados, numeros.dezPrimeirosInteirosMaioresQueCem());
    }
}
