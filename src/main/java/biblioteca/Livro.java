package biblioteca;

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    } // metodo construtor que recebe os valores


    // obter o título e retornar
    public String getTitulo() {
        return titulo;
    }

    // obter o autor e retornar
    public String getAutor() {
        return autor;
    }

    // obter o isbn e retornar
    public String getIsbn() {
        return isbn;
    }
}
