package exercicio74;

public class Calculadora {
    public int[] calcular() {
        int resultado = 0;
        int[] taboada = new int[100];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                resultado = i * j;
            }


        }
        int i = taboada[resultado];
        return taboada;
    }
}
