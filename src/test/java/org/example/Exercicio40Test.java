package org.example;

import lombok.var;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Exercicio40Test {

    private CalculadoraDeValorParaVenda calculadora;

    @Before
    public void init() {
        calculadora = new CalculadoraDeValorParaVenda();
    }

    @Test
    public void deve_calcular_valor_para_venda() {
        var totalEsperado = 50;
        var quantidade = 2;
        var preco = 25;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalEsperado, valorParaVenda.total);
    }

    @Test
    public void se_quantidade_for_menor_ou_igual_cinco_aplica_desconto_de_dois_porcento() {
        var descontoEsperado = 2;
        var quantidade = 2;
        var preco = 50;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(descontoEsperado, valorParaVenda.desconto);
    }

    @Test
    public void se_quantidade_for_maior_que_cinco_e_quantidade_menor_ou_igual_a_dez_aplica_desconto_tres_porcento() {
        var descontoEsperado = 3;
        var preco = 10;
        var quantidade = 10;

        ValorParaVenda valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(descontoEsperado, valorParaVenda.desconto);
    }

    @Test
    public void se_quantidade_for_maior_que_dez_aplica_desconte_de_cinco_porcento() {
        var descontoEsperado = 5;
        var preco = 5;
        var quantidade = 20;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(descontoEsperado, valorParaVenda.desconto);
    }

    @Test
    public void quando_quantidade_menor_que_cinco_desconto_de_2_porcento_eh_aplicado() {
        var totalAhPagarEsperado = 98;
        var quantidade = 2;
        var preco = 50;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalAhPagarEsperado, valorParaVenda.totalAhPagar);
    }

    @Test
    public void quando_quantidade_menor_que_dez_e_maior_que_cinco_eh_aplicado_desconto_de_3_porcento() {
        var totalAhPagarEsperado = 97;
        var preco = 10;
        var quantidade = 10;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalAhPagarEsperado, valorParaVenda.totalAhPagar);
    }

    @Test
    public void quando_quantidade_for_maior_que_dez_aplica_desconto_de_5_porcento() {
        var totalAhPagarEsperado = 95;
        var preco = 5;
        var quantidade = 20;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalAhPagarEsperado, valorParaVenda.totalAhPagar);
    }
}