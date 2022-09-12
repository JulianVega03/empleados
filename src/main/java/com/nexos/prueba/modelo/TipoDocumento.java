package com.nexos.prueba.modelo;

import com.nexos.prueba.Excepciones.TipoDocumentoNoPermitidoException;

public enum TipoDocumento {

    RC(1),
    TI(2),
    CC(3);
    CE(4);

    private final int idTipoDocumento;

    TipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public static TipoDocumento valueOf(Integer idTipoDocumento) throws TipoDocumentoNoPermitidoException {
        return Arrays.stream(TipoDocumento.values())
                .filter(value -> value.getIdTipoDocumento().equals(idTipoDocumento))
                .findAny()
                .orElseThrow(() -> new TipoDocumentoNoPermitidoException("Tipo de documento no permitido"));
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

}
