package exercicio41;

import lombok.Getter;

@Getter
public class Conceito {

    private String letra;

    public Conceito(double mediaDeAproveitamento) {
        if (mediaDeAproveitamento < 6)
            letra = "D";
        else if (mediaDeAproveitamento < 7.5)
            letra = "C";
        else if (mediaDeAproveitamento < 9)
            letra = "B";
        else
            letra = "A";
    }
}
