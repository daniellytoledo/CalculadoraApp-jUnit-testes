import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraAppTest {

    CalculadoraApp calc;
    @BeforeEach
    void configura() {
        calc = new CalculadoraApp();
    } // before each é uma função para ser executada antes de cada teste

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

    @Test
    void testDivisaoPorZeroLancaExcecaoComMensagemCorreta() {

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.dividir(10, 0);
        });

        assertEquals("Divisão por zero não permitida.", exception.getMessage());
    } // neste caso está testando para ver se a mensagem é a mesma esperada

    @AfterEach
    void limpa() {
        calc = null;
    } // after each é para ser executado depois de cada comando, isso libera espaço na memória a cada execução de teste

}