package exercicio67;

public class Calculadora {


    public double calcular() {
        double quantidade = 0;
        double soma = 0;
        for (int i = 15; i <= 100; i++) {
            soma += i;
            quantidade++;
        }
        return soma / quantidade;
    }
}