package exercicio63;

class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            int numero = leitor.ler();
            soma = soma + numero;
        }
        impressora.imprimir(soma);

    }
}
