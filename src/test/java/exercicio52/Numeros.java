package exercicio52;

public class Numeros {

    public int [] dezPrimeirosInteirosMaioresQueCem() {
        int[]resultado = new int[10];
        for (int numeroDaLista = 0; numeroDaLista < 10; numeroDaLista++) {
            resultado[numeroDaLista] = 101 + numeroDaLista;
        }
        return resultado;
    }
}
