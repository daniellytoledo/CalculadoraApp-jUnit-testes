import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class) // habilita o uso do @mock e @injectmock com jUnit 5

public class ServicoDePedidosTest {
    @Mock
    private RepositorioDePedidos repositorioFalso; 

    @InjectMocks
    private ServicoDePedido servico; // recebe automaticamente o mock no construtor

    @Test
    public void deveRetornarDescricaoDoPedido() {
        // dado um pedido simulado
        Pedido pedidoFalso = new Pedido(1, "Pedido de teste.");
        when(repositorioFalso.buscarPorId(1)).thenReturn(pedidoFalso); // when é o metodo do mockito

        // quando chamamos o metodo de serviço
        String resultado = servico.obterDescricaoDoPedido(1);

        // entao a descrição deve estar correta
        assertEquals("Pedido de teste.", resultado);
    }
}
