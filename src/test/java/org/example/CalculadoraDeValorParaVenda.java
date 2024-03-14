package org.example;

import lombok.var;

public class CalculadoraDeValorParaVenda {

    public ValorParaVenda calcular(double precoUnitario, int quantidadeAdiquirida) {
        var valorParaVenda = new ValorParaVenda();
        valorParaVenda.total = precoUnitario * quantidadeAdiquirida;
        if (quantidadeAdiquirida <= 5)
            valorParaVenda.desconto = valorParaVenda.total * (1 - 0.02);
        else if (quantidadeAdiquirida <= 10)
            valorParaVenda.desconto = valorParaVenda.total * (1 - 0.03);
        else
            valorParaVenda.desconto = valorParaVenda.total * (1 - 0.05);
        return valorParaVenda;
    }
}
