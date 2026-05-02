public class Desconto {
    public int descontoProgressivo(int quantidade) {
        if (quantidade <= 10) {
            return 5;
        } else if (quantidade <= 20) { // erro: deveria ser <= 20, não foi detectado no teste
            return 10;
        } else {
            return 15;
        }
    }
}
