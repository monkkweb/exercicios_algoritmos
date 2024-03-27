package exercicio43;

public class CalculadoraDeTriangulo {
    public String mensagem(int ladoA, int ladoB, int ladoC) {
        if ((ladoA < ladoB + ladoC) && (ladoB < ladoA + ladoC) && (ladoC < ladoA + ladoB)) {
            if ((ladoA == ladoB) && (ladoB == ladoC))
                return "Triangulo equilátero";
            else if ((ladoA == ladoB) || (ladoB == ladoC) || (ladoA == ladoC))
                return "Triangulo isósceles";
            else
                return "Triangulo escaleno";
        }
        return "Não é triangulo";
    }
}