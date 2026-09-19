package com.logistica.adaptee;

/**
 * Clase Adaptee - Sistema Legacy.
 *
 * Sistema heredado de rastreo de envios que devuelve datos en formato XML.
 *
 * ATENCION: NO MODIFIQUES ESTA CLASE.
 * Simula un sistema externo que no podemos cambiar.
 */
public class SistemaLegacyXml {

    /**
     * Consulta el estado de un envio y devuelve un String XML.
     *
     * @param codigoEnvio codigo interno del envio
     * @return String con formato XML
     */
    public String consultarEstadoXml(String codigoEnvio) {
        return String.format(
            "<envio>" +
            "<id>%s</id>" +
            "<estado>En transito</estado>" +
            "<origen>Lima</origen>" +
            "<destino>Arequipa</destino>" +
            "</envio>",
            codigoEnvio
        );
    }
}
