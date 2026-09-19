package com.logistica.adapter;

import com.logistica.adaptee.SistemaLegacyXml;
import com.logistica.target.RastreadorJson;
import org.json.JSONObject;
import org.json.XML;

public class AdaptadorXmlAJson implements RastreadorJson {

    private SistemaLegacyXml mSistemaLegacy;

    public AdaptadorXmlAJson(SistemaLegacyXml sistema) {
        mSistemaLegacy = sistema;
    }

    @Override
    public String obtenerEstadoJson(String idEnvio) {
        String respuestaXML = mSistemaLegacy.consultarEstadoXml(idEnvio);
        JSONObject json = XML.toJSONObject(respuestaXML);
        return json.toString(4);
    }
}
