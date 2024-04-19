package exercicio74;

public class Calculadora {
    public int[] calcular() {
        int[] resultado = new int[11];

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {

            for (int numero = 1; numero <= 10; numero++) {
                resultado[numero] = multiplicador * numero;
            }
        }

        return resultado;

    }
}
