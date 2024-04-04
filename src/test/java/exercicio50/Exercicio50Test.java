package exercicio50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio50Test {

    @Test
    public void numero_tem_que_ir_de_um_a_dez() {
        String numerosEsperado = "12345678910";

        Numero numeros = new Numero();

        Assertions.assertEquals(numerosEsperado, numeros.numerosCrescentes());
    }
}
