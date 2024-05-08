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
        for (int i = -1; i < 20; i++) {
            numeros.add(leitor.ler());
        }
        System.out.println(numeros);
        impressora.imprimir(numeros);
        int numeroVerificador = leitor.ler();
//        for (int i = 0; i < 20; i++) {
        if (numeros.contains(numeroVerificador)) {
            numeros.remove(Integer.valueOf(numeroVerificador));
//            }
            impressora.imprimir(numeros);
//            if (numeros.get(i) == numeroVerificador){
//            }
        }


    }
}
