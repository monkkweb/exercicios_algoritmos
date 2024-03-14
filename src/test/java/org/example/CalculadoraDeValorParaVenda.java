package org.example;

import lombok.var;

public class CalculadoraDeValorParaVenda {
    double precoUnitario = 25.00;
    int quantidadeAdiquirida = 2;

    public ValorParaVenda calcular() {
        var valorParaVenda = new ValorParaVenda();
        valorParaVenda.total = precoUnitario * quantidadeAdiquirida;
        valorParaVenda.desconto = 49;
        return valorParaVenda;
    }

}
