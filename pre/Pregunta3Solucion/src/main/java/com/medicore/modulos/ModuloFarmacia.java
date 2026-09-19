package com.medicore.modulos;

/**
 * Módulo interno de Farmacia.
 * Verifica stock y despacha medicamentos recetados.
 */
public class ModuloFarmacia {

    public boolean verificarStock(String medicamento) {
        System.out.println("  [Farmacia] Verificando stock de: " + medicamento);
        System.out.println("  [Farmacia] Medicamento disponible en inventario.");
        return true;
    }

    public boolean despacharMedicamento(String medicamento, String nombrePaciente) {
        System.out.println("  [Farmacia] Despachando '" + medicamento + "' a: " + nombrePaciente);
        System.out.println("  [Farmacia] Medicamento entregado correctamente.");
        return true;
    }
}
