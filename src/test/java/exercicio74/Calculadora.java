package exercicio74;

public class Calculadora {

    public int[] calcular() {
        int[] resultado = new int[10];

        for (int tabuada = 1; tabuada <= 10; tabuada++) {
            for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
                resultado[multiplicador - 1] = tabuada * multiplicador;
            }
        }
        return resultado;
    }
    //todo: colocar lista da lista(matriz)

}