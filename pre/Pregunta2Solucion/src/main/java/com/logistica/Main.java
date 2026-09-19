package com.logistica;

import com.logistica.adaptee.SistemaLegacyXml;
import com.logistica.adapter.AdaptadorXmlAJson;
import com.logistica.client.SistemaModerno;
import com.logistica.target.RastreadorJson;

/**
 * Punto de entrada del ejercicio.
 *
 * Este main ya esta implementado para mostrarte como se espera
 * que funcione el sistema una vez que completes las clases:
 *
 *   - AdaptadorXmlAJson  (paquete adapter)
 *   - SistemaModerno     (paquete client)
 *
 * NO modifiques este archivo hasta haber terminado las implementaciones.
 * Cuando el programa compile y ejecute sin errores, habras terminado.
 *
 * Salida esperada al ejecutar:
 * -------------------------------------------------------
 * === Demo Patron Adapter ===
 *
 * [Sistema Moderno] Estado del envio E-2024-001:
 * {"id":"E-2024-001","estado":"En transito","origen":"Lima","destino":"Arequipa"}
 *
 * [Sistema Moderno] Estado del envio E-2024-002:
 * {"id":"E-2024-002","estado":"En transito","origen":"Lima","destino":"Arequipa"}
 * -------------------------------------------------------
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Demo Patron Adapter ===\n");

        // 1. Crear el Adaptee (sistema legacy — interfaz XML)
        SistemaLegacyXml sistemaLegacy = new SistemaLegacyXml();

        // 2. Crear el Adapter que envuelve al Adaptee
        //    El adapter implementa RastreadorJson pero usa SistemaLegacyXml internamente
        RastreadorJson adapter = new AdaptadorXmlAJson(sistemaLegacy);

        // 3. Inyectar el adapter en el cliente moderno
        //    SistemaModerno solo conoce RastreadorJson, nunca a SistemaLegacyXml
        SistemaModerno sistema = new SistemaModerno(adapter);

        // 4. El cliente usa la interfaz moderna sin saber nada del sistema legacy
        sistema.mostrarEstadoEnvio("E-2024-001");
        System.out.println();
        sistema.mostrarEstadoEnvio("E-2024-002");
    }
}
