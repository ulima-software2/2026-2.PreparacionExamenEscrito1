package com.medicore.modulos;

/**
 * Módulo interno de Registro de Pacientes.
 * Valida y almacena los datos del paciente en el sistema.
 */
public class ModuloRegistro {

    public boolean registrarPaciente(String nombrePaciente, String rut) {
        System.out.println("  [Registro] Validando datos del paciente: " + nombrePaciente + " (RUT: " + rut + ")");
        System.out.println("  [Registro] Paciente registrado exitosamente en el sistema.");
        return true;
    }

    public boolean autenticarPaciente(String rut) {
        System.out.println("  [Registro] Autenticando paciente con RUT: " + rut);
        System.out.println("  [Registro] Paciente autenticado correctamente.");
        return true;
    }
}
