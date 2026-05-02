import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DescontoTest {

    @Test
    void testDesconto5() {
        Desconto calc = new Desconto();

        int desconto = calc.descontoProgressivo(9);
        assertEquals(5, desconto);
    }

    @Test
    void testDesconto10() {
        Desconto calc = new Desconto();

        int desconto = calc.descontoProgressivo(19);
        assertEquals(10, desconto);
    }

    @Test
    void testDesconto15() {
        Desconto calc = new Desconto();
        int desconto = calc.descontoProgressivo(29);
        assertEquals(15, desconto);
    }

}
