package com.medicore;

import com.medicore.modulos.*;

/**
 * PROBLEMA: Cliente (interfaz web/móvil) sin patrón de diseño.
 *
 */
public class Main {

    public static void main(String[] args) {

        // El cliente instancia DIRECTAMENTE cada módulo interno
        ModuloRegistro       moduloRegistro       = new ModuloRegistro();
        ModuloAgenda         moduloAgenda         = new ModuloAgenda();
        ModuloLaboratorio    moduloLaboratorio    = new ModuloLaboratorio();
        ModuloFarmacia       moduloFarmacia       = new ModuloFarmacia();
        ModuloSeguros        moduloSeguros        = new ModuloSeguros();
        ModuloFacturacion    moduloFacturacion    = new ModuloFacturacion();
        ModuloNotificaciones moduloNotificaciones = new ModuloNotificaciones();

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA MEDICORE - Sin patrón de diseño          ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // =====================================================================
        // CASO 1: Consulta Simple
        // El cliente conoce y orquesta manualmente cada paso
        // =====================================================================
        System.out.println("=== Iniciando: CONSULTA SIMPLE ===");

        String nombrePaciente1 = "Ana López";
        String rut1            = "12.345.678-9";
        String contacto1       = "ana.lopez@email.com";
        String especialidad1   = "Medicina General";

        // Paso 1: El cliente sabe que primero debe registrar al paciente
        moduloRegistro.registrarPaciente(nombrePaciente1, rut1);

        // Paso 2: El cliente sabe que debe buscar disponibilidad ANTES de reservar
        boolean hayDisponibilidad1 = moduloAgenda.buscarDisponibilidad(especialidad1);
        String numeroCita1 = null;
        if (hayDisponibilidad1) {
            numeroCita1 = moduloAgenda.reservarCita(nombrePaciente1, especialidad1);
        }

        // Paso 3: El cliente sabe que debe verificar el seguro ANTES de calcular monto
        moduloSeguros.verificarCobertura(rut1);

        // Paso 4: El cliente sabe que en consulta simple NO hay exámenes ni farmacia
        double monto1 = moduloFacturacion.calcularMontoTotal(false, false);

        // Paso 5: El cliente sabe el tipo de seguro y cuándo aplicarlo
        double montoFinal1 = moduloSeguros.aplicarDescuento(monto1, "FONASA");

        // Paso 6: El cliente sabe que debe emitir la boleta con el monto ya descontado
        String boleta1 = moduloFacturacion.emitirBoleta(nombrePaciente1, montoFinal1);

        // Paso 7: El cliente sabe qué datos combinar para armar el mensaje de confirmación
        moduloNotificaciones.enviarConfirmacion(
                nombrePaciente1, contacto1,
                "Consulta de " + especialidad1 + " | Cita: " + numeroCita1 + " | Boleta: " + boleta1
        );
        moduloNotificaciones.enviarRecordatorio(nombrePaciente1, contacto1, "2026-05-10 09:00");

        System.out.println("=== CONSULTA SIMPLE completada ===\n");


        // =====================================================================
        // CASO 2: Consulta con Exámenes
        // La misma lógica repetida, ahora con pasos adicionales de laboratorio
        // =====================================================================
        System.out.println("=== Iniciando: CONSULTA CON EXÁMENES ===");

        String nombrePaciente2 = "Carlos Mendoza";
        String rut2            = "15.678.901-2";
        String contacto2       = "+56912345678";
        String especialidad2   = "Medicina Interna";
        String tipoExamen2     = "Hemograma completo";

        // Paso 1: El cliente repite el registro (igual que antes)
        moduloRegistro.registrarPaciente(nombrePaciente2, rut2);

        // Paso 2: El cliente repite la búsqueda y reserva de agenda
        boolean hayDisponibilidad2 = moduloAgenda.buscarDisponibilidad(especialidad2);
        String numeroCita2 = null;
        if (hayDisponibilidad2) {
            numeroCita2 = moduloAgenda.reservarCita(nombrePaciente2, especialidad2);
        }

        // Paso 3: El cliente repite la verificación del seguro
        moduloSeguros.verificarCobertura(rut2);

        // Paso 4: Ahora el cliente sabe que TAMBIÉN debe solicitar exámenes
        // y que debe guardar el código para luego registrar resultados
        String codigoExamen2 = moduloLaboratorio.solicitarExamenes(nombrePaciente2, tipoExamen2);
        moduloLaboratorio.registrarResultados(codigoExamen2);

        // Paso 5: El cliente sabe pasar true para exámenes y false para farmacia
        double monto2 = moduloFacturacion.calcularMontoTotal(true, false);

        // Paso 6: El cliente sabe que este paciente tiene ISAPRE (distinto al anterior)
        double montoFinal2 = moduloSeguros.aplicarDescuento(monto2, "ISAPRE");

        // Paso 7: Emitir boleta
        String boleta2 = moduloFacturacion.emitirBoleta(nombrePaciente2, montoFinal2);

        // Paso 8: El cliente arma manualmente el mensaje de confirmación
        moduloNotificaciones.enviarConfirmacion(
                nombrePaciente2, contacto2,
                "Consulta " + especialidad2 + " + Examen: " + tipoExamen2
                + " | Cita: " + numeroCita2 + " | Boleta: " + boleta2
        );
        moduloNotificaciones.enviarRecordatorio(nombrePaciente2, contacto2, "2026-05-12 10:30");

        System.out.println("=== CONSULTA CON EXÁMENES completada ===\n");


        // =====================================================================
        // CASO 3: Atención Médica Completa
        // La lógica se vuelve aún más larga: registro + agenda + seguro +
        // laboratorio + farmacia + facturación + notificaciones
        // =====================================================================
        System.out.println("=== Iniciando: ATENCIÓN MÉDICA COMPLETA ===");

        String nombrePaciente3 = "María Torres";
        String rut3            = "18.234.567-3";
        String contacto3       = "maria.torres@gmail.com";
        String especialidad3   = "Traumatología";
        String tipoExamen3     = "Radiografía de rodilla";
        String medicamento3    = "Ibuprofeno 400mg";
        String tipoSeguro3     = "ISAPRE";

        // Paso 1: El cliente repite el registro (TERCERA VEZ en este archivo)
        moduloRegistro.registrarPaciente(nombrePaciente3, rut3);

        // Paso 2: El cliente repite búsqueda y reserva (TERCERA VEZ)
        boolean hayDisponibilidad3 = moduloAgenda.buscarDisponibilidad(especialidad3);
        String numeroCita3 = null;
        if (hayDisponibilidad3) {
            numeroCita3 = moduloAgenda.reservarCita(nombrePaciente3, especialidad3);
        }

        // Paso 3: El cliente repite verificación de seguro (TERCERA VEZ)
        moduloSeguros.verificarCobertura(rut3);

        // Paso 4: El cliente solicita exámenes de laboratorio
        String codigoExamen3 = moduloLaboratorio.solicitarExamenes(nombrePaciente3, tipoExamen3);
        moduloLaboratorio.registrarResultados(codigoExamen3);

        // Paso 5: El cliente también debe gestionar farmacia:
        // primero verificar stock, LUEGO despachar (el cliente conoce este orden)
        boolean hayStock3 = moduloFarmacia.verificarStock(medicamento3);
        if (hayStock3) {
            moduloFarmacia.despacharMedicamento(medicamento3, nombrePaciente3);
        }

        // Paso 6: El cliente pasa true para exámenes Y true para farmacia
        double monto3 = moduloFacturacion.calcularMontoTotal(true, true);

        // Paso 7: El cliente aplica el descuento según el tipo de seguro
        double montoFinal3 = moduloSeguros.aplicarDescuento(monto3, tipoSeguro3);

        // Paso 8: Emitir boleta
        String boleta3 = moduloFacturacion.emitirBoleta(nombrePaciente3, montoFinal3);

        // Paso 9: El cliente arma el mensaje manualmente (TERCERA VEZ con variaciones)
        moduloNotificaciones.enviarConfirmacion(
                nombrePaciente3, contacto3,
                "Atención completa | " + especialidad3
                + " | Examen: " + tipoExamen3
                + " | Medicamento: " + medicamento3
                + " | Cita: " + numeroCita3
                + " | Boleta: " + boleta3
        );
        moduloNotificaciones.enviarRecordatorio(nombrePaciente3, contacto3, "2026-05-15 08:00");

        System.out.println("=== ATENCIÓN MÉDICA COMPLETA completada ===\n");

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║       Todas las atenciones procesadas correctamente  ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }
}
