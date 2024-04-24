package exercicio73;


public class Calculadora {
    public static final double SALARIO_MENOR_QUE_150 = 150.00;
    private Leitor leitor;
    private Impressora impressora;

    public Calculadora(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        String comando;
        double somaSalario = 0;
        int totalPessoas = 0;
        int totalFilhos = 0;
        double maiorSalario = 0;
        int quantidadeDeSalarioMenorQue150 = 0;

        do {
            var salario = leitor.lerDouble();
            if (salario < 0)
                throw new RuntimeException("não pode ser negativo");
            somaSalario += salario;

            var numeroFilhos = leitor.lerInt();

            if (salario > maiorSalario)
                maiorSalario = salario;

            if (salario < SALARIO_MENOR_QUE_150)
                quantidadeDeSalarioMenorQue150++;

            totalFilhos += numeroFilhos;
            totalPessoas++;
            impressora.imprimirString("Mais alguma pessoa?");
            comando = leitor.lerString();
        } while (comando.equals("sim"));

        if (totalPessoas > 0) {
            double mediaSalario = somaSalario / totalPessoas;
            double mediaFilhos = (double) totalFilhos / totalPessoas;
            double percentualSalarioMenorQue150 = (double) quantidadeDeSalarioMenorQue150 / totalPessoas * 100;

            impressora.imprimirDouble(mediaSalario);
            impressora.imprimirDouble(mediaFilhos);
            impressora.imprimirDouble(maiorSalario);
            impressora.imprimirDouble(percentualSalarioMenorQue150);
        }
    }
}

