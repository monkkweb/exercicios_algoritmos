    package exercicio74;

    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.junit.jupiter.MockitoExtension;

    @ExtendWith(MockitoExtension.class)
    public class Exercicio74Test {

        @Test
        void deve_fazer_ah_taboada_do_um_ao_dez() {
            int[] tabuadaEsperada = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

            Calculadora calculadora = new Calculadora();

            Assertions.assertArrayEquals(tabuadaEsperada, calculadora.calcular());
        }
    }
