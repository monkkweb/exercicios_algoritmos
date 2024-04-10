package exercicio63;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        int numeros;
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            numeros = leitor.ler();
            soma = soma + numeros;
        }
        impressora.imprimir(soma);

    }
}
