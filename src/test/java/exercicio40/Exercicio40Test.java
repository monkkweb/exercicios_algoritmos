package exercicio40;

import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Exercicio40Test {

    @InjectMocks
    private CalculadoraDeValorParaVenda calculadora;

    @Test
void deve_calcular_valor_para_venda() {
        var totalEsperado = 50;
        var quantidade = 2;
        var preco = 25;

        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalEsperado, valorParaVenda.total);
    }

    @ParameterizedTest(name = "desconto é R${0} quando quantidade for {3}")
    @CsvSource({"2,2,50,<= 5", "3,10,10,<= 10", "5,20,5,> 10"})
    void se_quantidade_for_menor_ou_igual_cinco_aplica_desconto_de_dois_porcento(double descontoEsperado,
                                                                                        int quantidade, double preco,
                                                                                        String operador) {
        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(descontoEsperado, valorParaVenda.desconto);
    }

    @ParameterizedTest(name = "total a ser pago é R${0} quando for {3}")
    @CsvSource({"98,2,50,<= 5", "97,10,10,<= 10", "95,20,5,> 10"})
     void quando_quantidade_menor_que_cinco_desconto_de_2_porcento_eh_aplicado(int totalAhPagarEsperado,
                                                                                     int quantidade, double preco,
                                                                                     String operador) {
        var valorParaVenda = calculadora.calcular(preco, quantidade);

        Assertions.assertEquals(totalAhPagarEsperado, valorParaVenda.totalAhPagar);
    }
}