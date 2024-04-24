package exercicio76;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class Exercicio76Test {

    @Test
    void deve_imprimi_sessenta_colunas() {
        Impressora impressora = mock(Impressora.class);
        String quantidadeDeColunaEsperada = " +++++++++++++++++++++++ ";
        Matriz matriz = new Matriz(impressora);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        matriz.calcular();

        Mockito.verify(impressora, Mockito.times(600)).imprimir(argumentCaptor.capture());
        Assertions.assertEquals(quantidadeDeColunaEsperada, argumentCaptor.getAllValues().stream().collect(Collectors.joining("")));
    }
}

