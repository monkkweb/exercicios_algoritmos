package exercicio41;

import lombok.Getter;

@Getter
public class Media {

    private final Conceito conceito;
    private double mediaDeAproveitamento;
    private double mediaDosExercicios;

    public Media(double mediaDeAproveitamento, double mediaDosExercicios, Conceito conceito) {
        this.mediaDeAproveitamento = mediaDeAproveitamento;
        this.mediaDosExercicios = mediaDosExercicios;
        this.conceito = conceito;
    }
}
