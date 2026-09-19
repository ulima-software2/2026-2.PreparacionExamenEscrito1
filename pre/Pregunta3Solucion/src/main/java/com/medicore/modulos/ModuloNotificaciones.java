package com.medicore.modulos;

/**
 * Módulo interno de Notificaciones.
 * Envía confirmaciones y recordatorios al paciente por correo o SMS.
 */
public class ModuloNotificaciones {

    public void enviarConfirmacion(String nombrePaciente, String contacto, String detalle) {
        System.out.println("  [Notificaciones] Enviando confirmación a: " + nombrePaciente + " (" + contacto + ")");
        System.out.println("  [Notificaciones] Detalle: " + detalle);
        System.out.println("  [Notificaciones] Confirmación enviada exitosamente.");
    }

    public void enviarRecordatorio(String nombrePaciente, String contacto, String fechaCita) {
        System.out.println("  [Notificaciones] Programando recordatorio para: " + nombrePaciente);
        System.out.println("  [Notificaciones] Recordatorio agendado para 24h antes de: " + fechaCita);
    }
}
