package exercicio78;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Agenda {
    private Leitor leitor;
    private Impressora impressora;

    public Agenda(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    public void nomes() {
        impressora.imprimir("Nome das pessoas: ");
        List<String> nomesDasPessoas = Arrays.asList(leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(),
                leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler(), leitor.ler());

        impressora.imprimir("quem deseja procurar na lista? ");

        String mensagem = "NÃO ENCONTRADA!";
        String nomeProcurado = leitor.ler();

        for (String nome : nomesDasPessoas) {
            if (nome.equals(nomeProcurado)) {
                mensagem = "ENCONTRADA!";
            }
        }
        impressora.imprimir(mensagem);
        System.out.println(nomesDasPessoas);
    }
}
