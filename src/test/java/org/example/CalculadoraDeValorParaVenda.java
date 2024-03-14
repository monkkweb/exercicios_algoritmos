package org.example;

import lombok.var;

public class CalculadoraDeValorParaVenda {

    public ValorParaVenda calcular(double precoUnitario, int quantidadeAdiquirida) {
        var valorParaVenda = new ValorParaVenda();
        valorParaVenda.total = precoUnitario * quantidadeAdiquirida;
        valorParaVenda.desconto = valorParaVenda.total * (1 - 0.02);
        return valorParaVenda;
    }

}
