package exercicio79;


import java.util.Arrays;
import java.util.List;

public class Calculadora {

    private Leitor leitor;
    private Impressora impressora;

    public Calculadora(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        List<Double> notas = Arrays.asList(leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler()
                , leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler()
                , leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler()
                , leitor.ler());

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.toArray().length;
        impressora.imprimir(media);

        int alunosAcimaDaMedia = 0;
        for (double nota : notas) {
            if (nota >= 6)
                alunosAcimaDaMedia++;
        }
        impressora.imprimir(alunosAcimaDaMedia);
    }
}

