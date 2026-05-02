public class CalculadoraFinanceira {

    private final ConversorDeMoeda conversor;

    public CalculadoraFinanceira(ConversorDeMoeda conversor) {
        this.conversor = conversor;
    }

    public double somarEmReais(double valorReais, double valorEmDolar) {
        double convertido = conversor.dolarParaReal(valorEmDolar);
        return valorReais + convertido;
    }
}
