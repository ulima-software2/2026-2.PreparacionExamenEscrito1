package com.logistica.target;

/**
 * Interfaz Target.
 *
 * Define el contrato que el sistema moderno espera para consultar
 * el estado de un envio. Todos los datos se devuelven en formato JSON.
 *
 * INSTRUCCION PARA EL ALUMNO:
 *   Esta interfaz ya esta implementada. No la modifiques.
 *   Debes crear una clase que la implemente en el paquete "adapter".
 */
public interface RastreadorJson {

    /**
     * Devuelve el estado de un envio como cadena JSON.
     *
     * @param idEnvio identificador unico del envio (ej: "E-2024-001")
     * @return String con formato JSON, por ejemplo:
     *         {"id":"E-2024-001","estado":"En transito","origen":"Lima","destino":"Arequipa"}
     */
    String obtenerEstadoJson(String idEnvio);
}
