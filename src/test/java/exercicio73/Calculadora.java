package exercicio73;


public class Calculadora {
    private Leitor leitor;
    private Impressora impressora;

    public Calculadora(Leitor leitor, Impressora impressora) {
        this.leitor = leitor;
        this.impressora = impressora;
    }

    void calcular() {
        String comando;
        double salario;
        int numeroFilhos;
        double somaSalario = 0;
        int totalPessoas = 0;
        int totalFilhos = 0;
        double maiorSalario = 0;
        int salarioMenorQue150 = 0;

        do {
            salario = leitor.lerDouble();

            if (salario < 0) {
                throw new RuntimeException("não pode ser negativo");
            }

            numeroFilhos = leitor.lerInt();

            somaSalario += salario;
            totalPessoas++;
            totalFilhos += numeroFilhos;

            maiorSalario = salario > maiorSalario ? salario : maiorSalario;

            if (salario < 150.00) {
                salarioMenorQue150++;
            }

            impressora.imprimirString("mais alguma pessoa?");
            comando = leitor.lerString();
        }while (comando.equals("Sim"));

        if (totalPessoas > 0) {
            double mediaSalario = somaSalario / totalPessoas;
            double mediaFilhos = (double) totalFilhos / totalPessoas;
            double percentualSalarioMenorQue150 =  (double) salarioMenorQue150 / totalPessoas * 100;

            impressora.imprimirMediaDeSalario(mediaSalario);
            impressora.imprimirMediaDeFilhos(mediaFilhos);
            impressora.imprimirMaiorSalario(maiorSalario);
            impressora.imprimirPercentualDePessoasSalarioMenorQueCentoEhCinquenta(percentualSalarioMenorQue150);
        }
    }
}

