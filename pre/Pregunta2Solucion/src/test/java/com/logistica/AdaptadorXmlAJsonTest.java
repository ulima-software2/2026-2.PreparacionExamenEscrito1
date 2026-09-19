package com.logistica;

import com.logistica.adaptee.SistemaLegacyXml;
import com.logistica.adapter.AdaptadorXmlAJson;
import com.logistica.target.RastreadorJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de ejemplo para el AdaptadorXmlAJson.
 * Estos tests son parte de la tarea BONUS.
 *
 * Ejecutar con: mvn test
 *
 * Los tests fallaran con UnsupportedOperationException hasta que
 * implementes AdaptadorXmlAJson correctamente.
 */
class AdaptadorXmlAJsonTest {

    private RastreadorJson adapter;

    @BeforeEach
    void setUp() {
        SistemaLegacyXml legacy = new SistemaLegacyXml();
        adapter = new AdaptadorXmlAJson(legacy);
    }

    @Test
    @DisplayName("El resultado debe ser un String no nulo")
    void resultadoNoEsNulo() {
        String resultado = adapter.obtenerEstadoJson("E-001");
        assertNotNull(resultado, "El JSON resultante no debe ser null");
    }

    @Test
    @DisplayName("El resultado debe contener el id del envio")
    void resultadoContieneId() {
        String resultado = adapter.obtenerEstadoJson("E-2024-001");
        assertTrue(resultado.contains("E-2024-001"),
            "El JSON debe contener el id del envio");
    }

    @Test
    @DisplayName("El resultado debe tener formato JSON valido (llaves)")
    void resultadoEsFormatoJson() {
        String resultado = adapter.obtenerEstadoJson("E-001");
        assertTrue(resultado.trim().startsWith("{"),
            "El JSON debe iniciar con '{'");
        assertTrue(resultado.trim().endsWith("}"),
            "El JSON debe terminar con '}'");
    }

    @Test
    @DisplayName("El resultado NO debe contener etiquetas XML")
    void resultadoNoContieneXml() {
        String resultado = adapter.obtenerEstadoJson("E-001");
        assertFalse(resultado.contains("<"),
            "El JSON no debe contener el caracter '<'");
        assertFalse(resultado.contains(">"),
            "El JSON no debe contener el caracter '>'");
    }

    @Test
    @DisplayName("El resultado debe contener los campos esperados")
    void resultadoContieneCamposEsperados() {
        String resultado = adapter.obtenerEstadoJson("E-001");
        assertTrue(resultado.contains("estado"),  "Debe contener campo 'estado'");
        assertTrue(resultado.contains("origen"),  "Debe contener campo 'origen'");
        assertTrue(resultado.contains("destino"), "Debe contener campo 'destino'");
    }
}
