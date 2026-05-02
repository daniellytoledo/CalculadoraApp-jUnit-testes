import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraAppTest {

    CalculadoraApp calc;
    @BeforeEach
    void configura() {
        calc = new CalculadoraApp();
    }

    @Test
    void testSoma() {
        int resultado = calc.somaInteiros(3, 5);
        assertEquals(8, resultado, "Resultado Incorreto");
    }

    @Test
    void testDivide() {
        int resultado = calc.divideInteiros(10, 5);
        assertEquals(2, resultado, "A divisão está errada.");
    }

}