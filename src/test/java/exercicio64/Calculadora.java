package exercicio64;

public class Calculadora {

    private final Impressora impressora;
    private final Leitor leitor;

    Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    public void calcular() {
        int soma = 0;

        for (int i = 0; i < 10; i++) {
            int numero = leitor.ler();
            if (numero < 40) {
                soma = soma + numero;
            }
            impressora.imrprimir(soma);
        }
    }
}
