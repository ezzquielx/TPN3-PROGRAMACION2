class InteresCompuesto {

    public static void main(String[] args) {
        double inversionInicial = 100000.0;
        double tasaInteresAnual = 0.10;
        int anios = 10;

        double valorFuturo = calcularValorFuturo(inversionInicial, tasaInteresAnual, anios);

        double valorFuturoRedondeado = Math.round(valorFuturo * 100.0) / 100.0;

        System.out.println("Cálculo de interés compuesto:");
        System.out.println("Inversión inicial: $" + inversionInicial);
        System.out.println("Tasa de interés anual: " + (tasaInteresAnual * 100) + "%");
        System.out.println("Años: " + anios);
        System.out.println("Valor futuro (sin redondear): $" + valorFuturo);
        System.out.println("Valor futuro (redondeado): $" + valorFuturoRedondeado);
    }

    public static double calcularValorFuturo(double principal, double tasa, int tiempo) {
        return principal * Math.pow(1 + tasa, tiempo);
    }
}
