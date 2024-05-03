package exercicio72;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        List<Double> valores = new ArrayList<>();
        double maiorPreco = 0;
        double preco;
        double somaDosPrecos = 0;
        int quantidadeDeMercadoria;

        for (quantidadeDeMercadoria = 0; quantidadeDeMercadoria < 15; quantidadeDeMercadoria++) {
            int codigoDaMercadoria = leitor.lerInt();
            preco = leitor.lerDouble();
            somaDosPrecos += preco;
            valores.add(preco);
        }

        for (double precoAtual : valores) {
            maiorPreco = precoAtual > maiorPreco ? precoAtual : maiorPreco;
        }
        double media = somaDosPrecos / quantidadeDeMercadoria;
        impressora.imprimir(media);
        impressora.imprimir(maiorPreco);

    }
}
