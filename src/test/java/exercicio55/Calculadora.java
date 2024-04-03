package exercicio55;

public class Calculadora {
    public int[] calcular() {
        int[] tabuadaDoOito = new int[10];
        for (int valorMultiplicado = 0; valorMultiplicado < 10; valorMultiplicado++) {
            tabuadaDoOito[valorMultiplicado] = 8 * (1 + valorMultiplicado);
        }
        return tabuadaDoOito;
    }
}