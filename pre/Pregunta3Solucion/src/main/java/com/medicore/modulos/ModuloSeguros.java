package com.medicore.modulos;

/**
 * Módulo interno de Seguros Médicos.
 * Verifica cobertura del seguro y aplica descuentos correspondientes.
 */
public class ModuloSeguros {

    public boolean verificarCobertura(String rut) {
        System.out.println("  [Seguros] Verificando cobertura de seguro médico para RUT: " + rut);
        System.out.println("  [Seguros] Seguro médico activo y con cobertura vigente.");
        return true;
    }

    public double aplicarDescuento(double montoTotal, String tipoSeguro) {
        double descuento = tipoSeguro.equalsIgnoreCase("FONASA") ? 0.20 : 0.30;
        double montoConDescuento = montoTotal * (1 - descuento);
        System.out.printf("  [Seguros] Aplicando descuento %s (%.0f%%): $%.2f -> $%.2f%n",
                tipoSeguro, descuento * 100, montoTotal, montoConDescuento);
        return montoConDescuento;
    }
}
