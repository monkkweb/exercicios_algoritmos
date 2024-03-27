package exercicio40;

public class CalculadoraDeValorParaVenda {

    public ValorParaVenda calcular(double precoUnitario, int quantidadeAdiquirida) {
        double percentualDesconto;
        if (quantidadeAdiquirida <= 5)
            percentualDesconto = 0.02;
        else if (quantidadeAdiquirida <= 10)
            percentualDesconto = 0.03;
        else
            percentualDesconto = 0.05;
        return new ValorParaVenda(precoUnitario, quantidadeAdiquirida, percentualDesconto);
    }
}
