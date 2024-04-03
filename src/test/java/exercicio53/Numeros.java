package exercicio53;

import java.util.ArrayList;
import java.util.List;

public class Numeros {
    private Leitor leitor;
    private Impressora impressora;

    public Numeros(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    public void calcularNumerosInteiros() {
        int quantidadeDeNumeros = leitor.ler();
        List<Integer> resultado = new ArrayList<>();
        for (int numeroDaLista = 0; numeroDaLista < quantidadeDeNumeros; numeroDaLista++) {
            resultado.add(1 + numeroDaLista);
        }
        impressora.imprimir(resultado);
    }
}