package exercicio74;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculadora {

    public List<List<Integer>> calcular() {
        List<List<Integer>> tabuadaDoUmAoDez = new ArrayList<>();

        for (int tabuada = 1; tabuada <= 10; tabuada++) {
            List<Integer> valores = new ArrayList<>();
            valores.add(tabuada);
            for (int numeroMultiplicador = 1; numeroMultiplicador <= 10; numeroMultiplicador++) {
                valores.add(numeroMultiplicador *tabuada);
            }
            tabuadaDoUmAoDez.add(valores);
        }
        System.out.println(tabuadaDoUmAoDez);
        return tabuadaDoUmAoDez;
    }

}