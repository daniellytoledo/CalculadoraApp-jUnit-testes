import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculadoraFinanceiraTest {

    @Mock
    private ConversorDeMoeda conversorFalso;

    @InjectMocks
    private CalculadoraFinanceira calculadora;

    @Test
    public void deveSomarValorEmReaisComValorConvertidoDeDolar() {
        // simula que 1 dólar é 5 reais
        when(conversorFalso.dolarParaReal(10.0)).thenReturn(50.0);

        double resultado = calculadora.somarEmReais(100.0, 10.0);

        assertEquals(150.0, resultado);
    }

}

