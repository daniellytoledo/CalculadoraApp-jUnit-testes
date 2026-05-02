import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraAppTest {
    @Test
    void testSomaInteiros() {
        // configuração
        CalculadoraApp calc = new CalculadoraApp();

        // execução
        int resultado = calc.somaInteiros(2,2);

        // verificação
        assertEquals(4, resultado, "Resultado Incorreto!");
    }
}
