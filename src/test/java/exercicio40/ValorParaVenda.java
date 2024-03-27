package exercicio40;

public class ValorParaVenda {
    public double desconto;
    public double total;
    public double totalAhPagar;

    public ValorParaVenda(double preco, int quantidade, double percentualDesconto) {
        this.total = preco * quantidade;
        this.desconto = this.total * percentualDesconto;
        this.totalAhPagar = this.total - this.desconto;

    }
}
