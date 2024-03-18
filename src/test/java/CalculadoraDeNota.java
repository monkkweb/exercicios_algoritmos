public class CalculadoraDeNota {

    public int mediaDosExercicios(int notaUm, int notaDois, int notaTres) {
        return (notaUm + notaDois + notaTres) / 3;
    }

    public double mediaDeAproveitamento(int notaUm, int notaDois, int notaTres) {
        return (double) (notaUm + (notaDois * 2) + (notaTres * 3) + mediaDosExercicios(notaUm, notaDois, notaTres)) / 7;
    }
}
