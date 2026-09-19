package com.medicore.modulos;

/**
 * Módulo interno de Laboratorio.
 * Solicita exámenes médicos y registra sus resultados.
 */
public class ModuloLaboratorio {

    public String solicitarExamenes(String nombrePaciente, String tipoExamen) {
        String codigoExamen = "LAB-" + (int)(Math.random() * 9000 + 1000);
        System.out.println("  [Laboratorio] Solicitando examen '" + tipoExamen + "' para: " + nombrePaciente);
        System.out.println("  [Laboratorio] Examen registrado con código: " + codigoExamen);
        return codigoExamen;
    }

    public boolean registrarResultados(String codigoExamen) {
        System.out.println("  [Laboratorio] Registrando resultados para examen: " + codigoExamen);
        System.out.println("  [Laboratorio] Resultados disponibles en el sistema.");
        return true;
    }
}
