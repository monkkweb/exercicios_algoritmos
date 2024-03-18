public class Conceito {
    public String conceitos(double mediaDeAproveitamento) {

        if (mediaDeAproveitamento < 6)
            return "D";
        else if (mediaDeAproveitamento < 7.5) {
            return "C";
        } else if (mediaDeAproveitamento < 9) {
            return "B";
        } else
            return "A";

    }
}
