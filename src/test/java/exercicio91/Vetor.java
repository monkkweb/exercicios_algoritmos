package exercicio91;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vetor {
    private Leitor leitor;
    private Impressora impressora;

    public Vetor(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    public void calcular() {
        List<Integer> vetor = new ArrayList<>(50);

        for (int i = 0; i < 50; i++) {
            vetor.add(leitor.ler());
        }
        impressora.imprimirLista(vetor);

        List<Integer> posicoesDoNumeroRepetido = new ArrayList<>();
        Set<Integer> numerosRepetidos = new HashSet<>();

        for (int i = 0; i < 50; i++) {
            int numerosAtuais = vetor.get(i);
            if (vetor.indexOf(numerosAtuais) != i && !numerosRepetidos.contains(numerosAtuais)) {
                numerosRepetidos.add(numerosAtuais);
                posicoesDoNumeroRepetido.add(i);
            }
        }
        if (posicoesDoNumeroRepetido.isEmpty())
            impressora.imprimirSTring("Não tem numero repetido.");
        else {
            impressora.imprimirSTring("Tem numero repetido.");
        }
        impressora.imprimirLista(posicoesDoNumeroRepetido);
    }
}