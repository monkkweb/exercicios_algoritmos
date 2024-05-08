package exercicio85;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temperatura {

    private Leitor leitor;
    private Impressora impressora;

    public Temperatura(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        double menorTemperaturaDoAno = Double.MAX_VALUE;
        double maiorTemperaturaDoAno = 0;
        double soma = 0;
        double contadorDeDiasQueFoiAhBaixoDaMedia = 0;
        List<Double> temperaturas = new ArrayList<>(365);
        for (int i = 0; i < 365; i++) {
            temperaturas.add(leitor.ler());
            if (temperaturas.get(i) > maiorTemperaturaDoAno) {
                maiorTemperaturaDoAno = temperaturas.get(i);
            }
            if (temperaturas.get(i) < menorTemperaturaDoAno) {
                menorTemperaturaDoAno = temperaturas.get(i);
            }
        }
        for (double temperatura : temperaturas) {
            soma += temperatura;
        }
        double escala = Math.pow(10, 2);

        double media = Math.round((soma / temperaturas.toArray().length)*escala)/escala;
        for (int i = 0; i < 365; i++) {
            if (temperaturas.get(i) < media)
                contadorDeDiasQueFoiAhBaixoDaMedia++;
        }

        impressora.imprimir(Collections.singletonList(menorTemperaturaDoAno));
        impressora.imprimir(Collections.singletonList(maiorTemperaturaDoAno));
        impressora.imprimir(Collections.singletonList(media));
        impressora.imprimir(Collections.singletonList(contadorDeDiasQueFoiAhBaixoDaMedia));
    }
}
