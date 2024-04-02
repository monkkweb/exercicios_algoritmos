package exercicio53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class Exercicio5 {

    @Test
    public void contador_de_numeros_inteiros_ate_valor_n() {
        String numerosInteiros = "123345";
        ArgumentCaptor<StringBuilder> argumentCaptor = ArgumentCaptor.forClass(StringBuilder.class);
        Assertions.assertEquals(numerosInteiros, argumentCaptor.getValue());
    }
}
