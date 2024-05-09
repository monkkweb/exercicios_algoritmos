package exercicio88;


import java.util.ArrayList;
import java.util.List;

public class Vetor {

    private Leitor leitor;
    private Impressora impressora;

    public Vetor(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    public void numerador() {
        List<Integer> numeros = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            numeros.add(leitor.ler());
        }
        impressora.imprimir(numeros);

        int numeroVerificador = leitor.ler();

        List<Integer> numerosRefatorados = new ArrayList<>(21);
        numerosRefatorados.addAll(numeros);
        if (numerosRefatorados.contains(numeroVerificador)) {
            numerosRefatorados.remove(Integer.valueOf(numeroVerificador));
            impressora.imprimir(numerosRefatorados);
        } else {
            numerosRefatorados.add(numeroVerificador);
            impressora.imprimir(numerosRefatorados);
        }
    }
}