package com.nexos.prueba.Excepciones;

public class TipoDocumentoNoPermitidoException extends RuntimeException {
    public TipoDocumentoNoPermitidoException(String mensaje) {
        super(mensaje);
    }
}
