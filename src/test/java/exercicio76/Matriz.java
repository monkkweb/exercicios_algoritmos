package exercicio76;

public class Matriz {
    private Impressora impressora;

    public Matriz(Impressora impressora) {
        this.impressora = impressora;
    }

    public String calcular() {
        StringBuilder resultado = new StringBuilder();
        char caractere;
        for (int linha = 1; linha <= 10; linha++) {
            for (int coluna = 1; coluna <= 60; coluna++) {
                if (linha == 1 || linha == 10 || coluna == 1 || coluna == 60) {
                    caractere = '+';
                } else {
                    caractere = ' ';
                }
                impressora.imprimir(String.valueOf(caractere));
            }
            impressora.imprimir("\n");
        }
        return resultado.toString();
    }
}