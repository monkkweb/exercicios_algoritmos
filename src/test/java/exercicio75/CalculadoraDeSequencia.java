package exercicio75;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeSequencia {

    public List<List<Integer>> calcular() {
        List<List<Integer>> listaQueVaiDeUmAhDezDezVezes = new ArrayList<>();

        for (int numero = 1; numero <= 10; numero++) {
            List<Integer> numeros = new ArrayList<>();
            numeros.add(numero);

            for (int sequencia = 1; sequencia <= 10; sequencia++) {
                numeros.add(sequencia);
            }
            listaQueVaiDeUmAhDezDezVezes.add(numeros);
        }
        System.out.println(listaQueVaiDeUmAhDezDezVezes);
        return listaQueVaiDeUmAhDezDezVezes;
    }
}
