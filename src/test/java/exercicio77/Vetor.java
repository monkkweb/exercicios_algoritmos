package exercicio77;

public class Vetor {

    public int[] calcular() {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 7; i >= 5; i--) {
            int aux = v[i];
            v[i] = v[8 - i + 1];
            v[8 - i + 1] = aux;
        }
        v[3] = v[1];
        v[v[3]] = v[v[2]];
        System.out.println(v);
        return v;
    }
}
