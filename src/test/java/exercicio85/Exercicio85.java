package exercicio85;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Exercicio85 {
    @Captor
    private ArgumentCaptor<List<Double>> argumentCaptor;

    @Test
    void deve_informar_a_menor_temperatura_ano() {
        List<Double> temperaturaEsperada = Arrays.asList(10d);

        Assertions.assertEquals(temperaturaEsperada, argumentCaptor.getValue());
    }
}
