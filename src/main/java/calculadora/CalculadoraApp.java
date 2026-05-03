package calculadora;

public class CalculadoraApp {

    public int somaInteiros(int a, int b) {
        return (a + b);
    }

    public int divideInteiros(int a, int b) {
        return (a / b);
    }

    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida.");
        }
        return a / b;
    }

    public static void main (String[] args) {
        CalculadoraApp calc = new CalculadoraApp();
        System.out.println(calc.somaInteiros(9, 2));

        System.out.println(calc.divideInteiros(10, 2));
    }
}

