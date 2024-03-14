package org.example;

import lombok.var;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Exercicio40Test {

    @Test
    public void deve_calcular_valor_para_venda() {
        double totalEsperado = 50;
        var calculadora = new CalculadoraDeValorParaVenda();
        int quantidade = 2;
        double preco = 25;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalEsperado, valorParaVenda.total);
    }

    @Test
    public void se_quantidade_for_menor_ou_igual_cinco_aplica_desconto_de_dois_porcento() {
        double totalEsperado = 98;
        var calculadora = new CalculadoraDeValorParaVenda();
        var quantidade = 2;
        double preco = 50;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalEsperado, valorParaVenda.desconto);
    }

    @Test
    public void se_quantidade_for_maior_que_cinco_e_quantidade_menor_ou_igual_a_dez_aplica_desconto_tres_porcento() {
        double totalEsperado = 97;
        var calculadora = new CalculadoraDeValorParaVenda();
        double preco = 10;
        int quantidade = 10;

        ValorParaVenda valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalEsperado, valorParaVenda.desconto);
    }
}