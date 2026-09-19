package com.medicore.modulos;

/**
 * Módulo interno de Facturación.
 * Calcula el monto total de la atención y emite la boleta correspondiente.
 */
public class ModuloFacturacion {

    public double calcularMontoTotal(boolean incluyeExamenes, boolean incluyeFarmacia) {
        double montoBase     = 25000.0;
        double montoExamenes = incluyeExamenes ? 45000.0 : 0.0;
        double montoFarmacia = incluyeFarmacia  ? 12000.0 : 0.0;
        double total = montoBase + montoExamenes + montoFarmacia;
        System.out.printf("  [Facturación] Monto consulta: $%.2f | Exámenes: $%.2f | Farmacia: $%.2f%n",
                montoBase, montoExamenes, montoFarmacia);
        System.out.printf("  [Facturación] Total calculado: $%.2f%n", total);
        return total;
    }

    public String emitirBoleta(String nombrePaciente, double monto) {
        String numeroBoleta = "BOL-" + System.currentTimeMillis() % 100000;
        System.out.printf("  [Facturación] Emitiendo boleta %s para %s por $%.2f%n",
                numeroBoleta, nombrePaciente, monto);
        return numeroBoleta;
    }
}
