package exercicio76;

import java.util.ArrayList;
import java.util.List;

public class Matriz {

    public static final int LINHAS = 10;
    public static final int COLUNAS = 60;

    public List<String> criarMatriz() {
        List<List<Integer>> resultado = new ArrayList<>();

        for (int i = 1; i <= LINHAS; i++) {
            List<Integer> linhas = new ArrayList<>();
            linhas.add(i);

            for (int sequencia = 1; sequencia <= 10; sequencia++) {
                numeros.add(sequencia);
            }
            resultado.add(numeros);
        }
        System.out.println(resultado);
        return resultado.get(9);
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

