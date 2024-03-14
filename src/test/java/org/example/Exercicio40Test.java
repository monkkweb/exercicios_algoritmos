package org.example;

import lombok.var;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Exercicio40Test {
    @Test
    public void deve_calcular_valor_para_venda() {
        double totalEsperado = 50;
        var calculadora = new CalculadoraDeValorParaVenda();

        var valorParaVenda = calculadora.calcular();

        Assertions.assertEquals(totalEsperado, valorParaVenda.total);
    }

    @Test
    public void deve_calcular_valor_com_desconto_cliente() {
        double totalEsperado = 49;
        var calculadora = new CalculadoraDeValorParaVenda();

        var valorParaVenda = calculadora.calcular();

        Assertions.assertEquals(totalEsperado, valorParaVenda.desconto);
    }
}

