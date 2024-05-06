package exercicio83;


import exercicio51.Numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vetor {

    private Leitor leito;
    private Impressora impressora;

    public Vetor(Leitor leito, Impressora impressora) {
        this.leito = leito;
        this.impressora = impressora;
    }

    void inverter() {
        List<Integer> numeros = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            numeros.add(leito.ler());
        }
        Collections.reverse(numeros);
        //        for (int i = 20; i > 0; i--) {
        impressora.imprimir(numeros);
        System.out.println(numeros);
//        }

    }
}
