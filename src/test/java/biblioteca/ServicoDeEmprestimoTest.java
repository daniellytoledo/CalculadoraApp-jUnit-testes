package biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicoDeEmprestimoTest {

    @Test
    void deveEmprestarLivroExistente() {
        // arrange
        RepositorioDeLivros repositorio = new RepositorioDeLivros();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "123");
        repositorio.adicionarLivro(livro);

        ServicoDeEmprestimo servico = new ServicoDeEmprestimo(repositorio);

        // act
        boolean emprestado = servico.emprestarLivro("123");

        // assert
        assertTrue(emprestado);
    }

    @Test
    void naoDeveEmprestarLivroInexistente() {
        // arrange
        RepositorioDeLivros repositorio = new RepositorioDeLivros();
        ServicoDeEmprestimo servico = new ServicoDeEmprestimo(repositorio);

        // act
        boolean emprestado = servico.emprestarLivro("999");

        // assert
        assertFalse(emprestado);
    }


}
