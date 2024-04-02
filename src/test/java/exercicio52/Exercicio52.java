package exercicio52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio52 {

    @Test
    public void os_dez_primeiros_numeros_inteiros_maior_que_cem_() {

        String numerosInteirosEsperados = "101102103104105106107108109110";

        Numeros numeros = new Numeros();
        Assertions.assertEquals(numerosInteirosEsperados, numeros.numerosInteiros());
    }
}
