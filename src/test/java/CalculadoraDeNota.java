import lombok.var;

public class CalculadoraDeNota {

//    public int mediaDosExercicios(int notaUm, int notaDois, int notaTres) {
//        return (notaUm + notaDois + notaTres) / 3;
//    }

    public Media mediaDeAproveitamento(int notaUm, int notaDois, int notaTres) {
        if (notaUm < 0)
            throw new RuntimeException("Nota não pode ser menor que zero");
        if (notaDois < 0)
            throw new RuntimeException("Nota não pode ser menor que zero");
        if (notaTres < 0)
            throw new RuntimeException("Nota não pode ser menor que zero");

        var mediaDosExercicios = (notaUm + notaDois + notaTres) / 3;
        var mediaDeAproveitamento = (notaUm + (notaDois * 2) + (notaTres * 3) + mediaDosExercicios) / 7;

        return new Media(mediaDeAproveitamento, mediaDosExercicios);
    }
}
