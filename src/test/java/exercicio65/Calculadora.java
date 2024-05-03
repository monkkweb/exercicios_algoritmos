package exercicio65;

public class Calculadora {
    private Impressora impressora;
    private Leitor leitor;

    public Calculadora(Impressora impressora, Leitor leitor) {
        this.impressora = impressora;
        this.leitor = leitor;
    }

    void calcular() {
        var soma = 0;
        var valorInicial = leitor.ler();
        var valorFinal = leitor.ler();
        if (valorFinal < valorInicial)
            impressora.imprimirString("SEGUNDO VALOR TEM QUE SER MAIOR!!!");

        for (int i = valorInicial; i <= valorFinal; i++) {
            soma += i;
        }
        impressora.imprimirInt(soma);
    }
}
