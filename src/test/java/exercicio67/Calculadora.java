package exercicio67;

public class Calculadora {

    private Impressora impressora;

    public Calculadora(Impressora impressora) {
        this.impressora = impressora;
    }

    void calcular() {
        double quantidade = 0;
        double soma = 0;
        for (int i = 15; i <= 100; i++) {
            soma += i;
            quantidade++;
        }

        impressora.imprimir(soma / quantidade);
    }
}