package exercicio76;

public class Matriz {
    private Impressora impressora;

    public Matriz(Impressora impressora) {
        this.impressora = impressora;
    }

    public void calcular() {
        String[][] matriz = new String[10][60];
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 60; coluna++) {
                if (linha == 0 || linha == 9 || coluna == 0 || coluna == 59) {
                    matriz[linha][coluna] = "+";
                } else {
                    matriz[linha][coluna] = " ";
                }
                impressora.imprimir(matriz[linha][coluna]);
            }
        }
    }
}