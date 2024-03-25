import lombok.var;

import java.time.LocalDate;

public class VerificaAposentadoriaDoFuncionario {

    public static final int IDADE_MINIMA_PARA_APOSENTAR = 65;
    public static final int TEMPO_MINIMO_DE_TRABALHO_PARA_APOSENTAR = 30;
    public static final int IDADE_MINIMA_PARA_APOSENTAR_POR_TEMPO_DE_TRABALHO_E_IDADE = 60;
    public static final int TEMPO_MINIMO_PARA_APOSENTAR_POR_TEMPO_DE_TRABALHO_E_IDADE = 25;

    public CalculoAposentadoria verificar(int codigo, int anoDeNascimento, int anoIngresso) {
        var anoAtual = LocalDate.now().getYear();
        var idade = anoAtual - anoDeNascimento;
        var tempoDeTrabalho = anoAtual - anoIngresso;
        var atingiuTempoEIdadeParaAposentar = idade >= IDADE_MINIMA_PARA_APOSENTAR_POR_TEMPO_DE_TRABALHO_E_IDADE &&
                tempoDeTrabalho >= TEMPO_MINIMO_PARA_APOSENTAR_POR_TEMPO_DE_TRABALHO_E_IDADE;
        validarSe(anoDeNascimento > anoIngresso, "Ano de nascimento não pode ser maior que o ano atual.");
        validarSe(anoDeNascimento > anoAtual, "Ano atual não pode ser menor que ano de nascimento.");
        validarSe(anoIngresso > anoAtual, "Ano de ingresso não pode ser maior que o ano atual.");
        var mensagem = idade >= IDADE_MINIMA_PARA_APOSENTAR || tempoDeTrabalho >= TEMPO_MINIMO_DE_TRABALHO_PARA_APOSENTAR ||
                atingiuTempoEIdadeParaAposentar ? "Requer aposentadoria" : "Não requer aposentadoria";
        return new CalculoAposentadoria(codigo, idade, tempoDeTrabalho, mensagem);
    }

    private static void validarSe(boolean ehVerdadeiro, String mensagem) {
        if (ehVerdadeiro)
            throw new RuntimeException(mensagem);


    }
}