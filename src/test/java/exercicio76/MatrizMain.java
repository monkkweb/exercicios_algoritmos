package exercicio76;

public class MatrizMain {

    public static void main(String[] args) {
        /**
         * Colocar dentro de uma classe E CRIAR TESTES
         *
         *
         */
        final int LINHAS = 10;
        final int COLUNAS = 60;

        String[][] matriz = criarMatriz(LINHAS, COLUNAS);

        String[][] matrizComBordaPreenchida = preencherBordaComCaracteres(matriz, LINHAS, COLUNAS, "+");

        String[][] matrizComTextoPosicionado = posicionar(matrizComBordaPreenchida, "Olá", 2, 10);

        // Imprimindo a matriz
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                System.out.print(matrizComTextoPosicionado[i][j] + " ");
            }
            System.out.println(); // Quebra de linha entre as linhas da matriz
        }
    }

    private static String[][] criarMatriz(int linhas, int colunas) {
        String[][] matriz = new String[linhas][colunas];
        /**
         * preenchendo a matriz com string vazia
         *  Nessa Etapa iremos criar a matriz dando um new e preenchendo os campos com string  vazia
         */
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = " ";
            }
        }

        return matriz;
    }

    public static String[][] preencherBordaComCaracteres(String[][] matriz, int linhas, int colunas, String caractere) {
        /**
         *  Criando a borda e preenchendo com caractere
         *  Nessa Etapa iremos criar a bora da matriz com o caractere selecionado
         *
         *  i == 0 => Primeira Linha
         *  i == linhas -1 => Ultima Linha
         *
         *  j == 0 => Primeira Coluna
         *  j == colunas - 1 => Ultima coluna
         */
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == 0 || i == linhas - 1 || j == 0 || j == colunas - 1)
                    matriz[i][j] = caractere;
            }
        }

        return matriz;
    }

    public static String[][] posicionar(String[][] matriz, String texto, int linha, int coluna) {
        /**
         *  posicionando o texto a partir da linha e da coluna
         *  Nessa Etapa posicionar o texto a partir da linha e da coluna informadas
         *
         *  OBS: texto.length() e String.valueOf(texto.charAt(i)) são features do Java
         *
         *  texto = 'O l á   M u n d o'
         *  coluna 10 + 0 = 10 = primeira letra
         *  coluna 10 + 1 = 11 = segunda letra
         */
        for (int i = 0; i < texto.length(); i++) {
            if (coluna + i < 59) // Criar teste d evalidação para a classe Matriz
                matriz[linha][coluna + i] = String.valueOf(texto.charAt(i));
        }
        return matriz;
    }
}
