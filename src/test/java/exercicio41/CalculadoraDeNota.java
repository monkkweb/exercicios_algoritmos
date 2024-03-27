package exercicio41;

import exercicio41.Media;
import lombok.var;

public class CalculadoraDeNota {
    public Media calcular(int notaUm, int notaDois, int notaTres) {
        if (notaUm < 0)
            throw new RuntimeException("Nota não pode ser menor que zero");
        if (notaDois < 0)
            throw new RuntimeException("Nota não pode ser menor que zero");
        if (notaTres < 0)
            throw new RuntimeException("Nota não pode ser menor que zero");

        double mediaDosExercicios = (notaUm + notaDois + notaTres) / 3f;
        double mediaDeAproveitamento = (notaUm + (notaDois * 2) + (notaTres * 3) + mediaDosExercicios) / 7f;

        var conceito = new Conceito(mediaDeAproveitamento);
        return new Media(mediaDeAproveitamento, mediaDosExercicios, conceito);
    }
}
