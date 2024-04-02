package exercicio50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio50 {

    @Test
    public void numero_tem_que_ser_menor_que_um() {
        String numerosEsperado = "12345678910";

        Numero numeros = new Numero();

        Assertions.assertEquals(numerosEsperado, numeros.numerosCrescentes());
    }
}
