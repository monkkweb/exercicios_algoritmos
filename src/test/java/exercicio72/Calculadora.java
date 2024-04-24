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
        double maiorPreco = 0;
        double preco;
        double somatoria = 0;
        int quantidadeDeMercadoria;
        List<Double> valores = new ArrayList<>();
        for (quantidadeDeMercadoria = 0; quantidadeDeMercadoria < 15; quantidadeDeMercadoria++) {
            int codigoDaMercadoria = leitor.lerInt();
            preco = leitor.lerDouble();
            somatoria += preco;
            valores.add(preco);
        }

        for (double precoAtual : valores) {
            maiorPreco = precoAtual > maiorPreco ? precoAtual : maiorPreco;
        }
        double media = somatoria / quantidadeDeMercadoria;
        impressora.imprimir(media);
        impressora.imprimir(maiorPreco);

    }
}
