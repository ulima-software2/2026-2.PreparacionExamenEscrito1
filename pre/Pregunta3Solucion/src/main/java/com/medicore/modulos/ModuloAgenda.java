package com.medicore.modulos;

/**
 * Módulo interno de Agenda Médica.
 * Busca disponibilidad de médicos y reserva citas.
 */
public class ModuloAgenda {

    public boolean buscarDisponibilidad(String especialidad) {
        System.out.println("  [Agenda] Buscando disponibilidad para especialidad: " + especialidad);
        System.out.println("  [Agenda] Se encontraron horarios disponibles.");
        return true;
    }

    public String reservarCita(String nombrePaciente, String especialidad) {
        String numeroCita = "CITA-" + (int)(Math.random() * 9000 + 1000);
        System.out.println("  [Agenda] Reservando cita de " + especialidad + " para: " + nombrePaciente);
        System.out.println("  [Agenda] Cita reservada con número: " + numeroCita);
        return numeroCita;
    }
}
