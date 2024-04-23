package exercicio76;

import java.util.ArrayList;
import java.util.List;

public class Matriz {

//    public static final int LINHAS = 10;
//    public static final int COLUNAS = 60;

    public String criarMatriz() {
        List<String> resultado = new ArrayList<>();

        for (int coluna = 1; coluna <= 60; coluna++) {
            List<Integer> linhas = new ArrayList<>();
            linhas.add(coluna);

            for (int linha = 1; linha <= 10; linha++) {
                linhas.add(linha);
            }
            resultado.add(linhas.toString());
        }
        System.out.println(resultado);
        return String.valueOf(resultado);
    }

}
//    public static void main(String[] args) {
//
//
//        final int LINHAS = 10;
//        final int COLUNAS = 60;
//        String[][] matriz = criarMatriz(LINHAS, COLUNAS);
//        String[][] matrizComBordaPreenchida = preencherBordaComCaracteres(matriz, LINHAS, COLUNAS, "+");
//        String[][] matrizComTextoPosicionado = posicionar(matrizComBordaPreenchida, "Olá", 2, 10);
//        for (int i = 0; i < LINHAS; i++) {
//            for (int j = 0; j < COLUNAS; j++) {
//                System.out.print(matrizComTextoPosicionado[i][j] + " ");
//            }
//            System.out.println();
//
//        }
//    }
//
//    private static String[][] criarMatriz(int linhas, int colunas) {
//        String[][] matriz = new String[linhas][colunas];
//        for (int i = 0; i < linhas; i++) {
//            for (int j = 0; j < colunas; j++) {
//                matriz[i][j] = " ";
//            }
//        }
//        return impressora.imprimir(matriz);
//    }

