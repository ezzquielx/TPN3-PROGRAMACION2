class EficienciaEnergetica {
    public static void main(String[] args) {
        Electrodomesticos e = new Electrodomesticos(10, 200.0, 90, 175, 120);
        double reduccion = 30;

        System.out.println("===== CÁLCULO DE EFICIENCIA ENERGÉTICA =====\n");
        System.out.println("LISTA DE ELECTRODOMÉSTICOS:");
        e.mostrarListaElectrodomesticos();

        System.out.println("\nANÁLISIS DE CONSUMO:");
        System.out.printf("Consumo total anual: %.1f kWh%n", e.getConsumoTotal());
        System.out.printf("Electrodoméstico de mayor consumo: %s (%.1f kWh)%n",
                e.getElectrodomesticoMax(), e.getMaxConsumo());
        System.out.printf("Electrodoméstico de menor consumo: %s (%.1f kWh)%n",
                e.getElectrodomesticoMin(), e.getMinConsumo());
        System.out.printf("Diferencia entre máximo y mínimo: %.1f kWh%n",
                e.getDiferenciaConsumo());

        System.out.println("\nAHORRO ENERGÉTICO (REDUCCIÓN DEL 30%):");
        System.out.printf("Ahorro anual: %.2f kWh%n", e.getAhorroEnergetico(reduccion));
        System.out.printf("Consumo después de implementar medidas de ahorro: %.2f kWh%n",
                e.getConsumoReducido(reduccion));
        System.out.printf("Raíz cuadrada del ahorro: %.2f %n", e.getRaizAhorro(reduccion));
    }
}

class Electrodomesticos {
    private double heladera, aireAcondicionado, televisor, microondas, lavarropas;

    public Electrodomesticos(double heladera, double aire, double tv, double micro, double lavadora) {
        this.heladera = heladera;
        this.aireAcondicionado = aire;
        this.televisor = tv;
        this.microondas = micro;
        this.lavarropas = lavadora;
    }
    public void mostrarListaElectrodomesticos() {
        System.out.printf("1. heladera: %.1f kWh%n", heladera);
        System.out.printf("2. Aire Acondicionado: %.1f kWh%n", aireAcondicionado);
        System.out.printf("3. Televisor: %.1f kWh%n", televisor);
        System.out.printf("4. Microondas: %.1f kWh%n", microondas);
        System.out.printf("5. Lavarropas: %.1f kWh%n", lavarropas);
    }
    public double getConsumoTotal() {
        return heladera + aireAcondicionado + televisor + microondas + lavarropas;
    }
    public double getMaxConsumo() {
        return Math.max(Math.max(heladera, aireAcondicionado),
                Math.max(Math.max(televisor, microondas), lavarropas));
    }
    public double getMinConsumo() {
        return Math.min(Math.min(heladera, aireAcondicionado),
                Math.min(Math.min(televisor, microondas), lavarropas));
    }
    public String getElectrodomesticoMax() {
        double max = getMaxConsumo();
        if (max == heladera) return "heladera";
        if (max == aireAcondicionado) return "Aire Acondicionado";
        if (max == televisor) return "Televisor";
        if (max == microondas) return "Microondas";
        return "Lavarropas";
    }
    public String getElectrodomesticoMin() {
        double min = getMinConsumo();
        if (min == heladera) return "heladera";
        if (min == aireAcondicionado) return "Aire Acondicionado";
        if (min == televisor) return "Televisor";
        if (min == microondas) return "Microondas";
        return "Lavarropas";
    }
    public double getDiferenciaConsumo() {
        return getMaxConsumo() - getMinConsumo();
    }

    public double getAhorroEnergetico(double porcentaje) {
        return getConsumoTotal() * (porcentaje / 100);
    }

    public double getConsumoReducido(double porcentaje) {
        return getConsumoTotal() - getAhorroEnergetico(porcentaje);
    }

    public double getRaizAhorro(double porcentaje) {
        return Math.sqrt(getAhorroEnergetico(porcentaje));
    }
}