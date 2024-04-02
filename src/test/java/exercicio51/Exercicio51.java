package exercicio51;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio51 {

    @Test
    public void numero_tem_que_ser_menor_que_dez() {
        String numerosEsperados = "10987654321";

        Numeros numeros = new Numeros();

        Assertions.assertEquals(numerosEsperados, numeros.numerosDecrescentes());
    }
}