package com.logistica.client;

import com.logistica.target.RastreadorJson;

/**
 * TAREA: Implementar esta clase.
 *
 * SistemaModerno es el Client del patron Adapter.
 *
 * Importante:
 *  - Solo conoce la interfaz RastreadorJson (Target).
 *  - NO debe importar ni referenciar SistemaLegacyXml.
 *  - Recibe el RastreadorJson por constructor (inyeccion de dependencias).
 *
 * Debe implementar el metodo mostrarEstadoEnvio(String idEnvio)
 * que consulte el estado e imprima por consola algo como:
 *
 *   [Sistema Moderno] Estado del envio E-2024-001:
 *   {"id":"E-2024-001","estado":"En transito","origen":"Lima","destino":"Arequipa"}
 */
public class SistemaModerno {

    // TODO: declarar el atributo de tipo RastreadorJson
    private RastreadorJson mRastreador;
    // TODO: implementar el constructor con inyeccion de dependencias
    public SistemaModerno(RastreadorJson rastreadorJson) {
        mRastreador = rastreadorJson;
    }
    /**
     * Consulta e imprime el estado de un envio.
     *
     * @param idEnvio identificador del envio a consultar
     */
    public void mostrarEstadoEnvio(String idEnvio) {
        String envio = mRastreador.obtenerEstadoJson(idEnvio);
        System.out.println("[sistema Moderno] Estado del envio " + idEnvio);
        System.out.println(envio);
    }
}
