package exercicio89;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vetor {

    public static final int TAMANHA_DO_ARRAY = 15;
    private Leitor leitor;
    private Impressora impressora;

    public Vetor(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        List<Integer> vetorUm = new ArrayList<>(TAMANHA_DO_ARRAY);
        int numerosIguais = 0;
        List<Integer> vetorDois = new ArrayList<>(TAMANHA_DO_ARRAY);

        for (int i = 0; i < TAMANHA_DO_ARRAY; i++) {
            vetorUm.add(leitor.ler());
        }
        impressora.imprimirLista(vetorUm);

        for (int i = 0; i < TAMANHA_DO_ARRAY; i++) {
            vetorDois.add(leitor.ler());
        }
        impressora.imprimirLista(vetorDois);

        for (int i = 0; i < TAMANHA_DO_ARRAY; i++) {
            if (Objects.equals(vetorUm.get(i), vetorDois.get(i)))
                numerosIguais++;
        }
        impressora.imprimirInt(numerosIguais);
    }
}
