public class CalculadoraApp {

    public int somaInteiros(int a, int b) {
        return (a + b);
    }

    public static void main (String[] args) {
        CalculadoraApp calc = new CalculadoraApp();
        System.out.println(calc.somaInteiros(9, 2));
    }
}

