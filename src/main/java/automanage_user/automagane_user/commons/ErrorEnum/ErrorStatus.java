package com.ecommerce_rest.ecommerce_rest.commons.ErrorEnum;

import lombok.Getter;

@Getter
public enum ErrorStatus {

    NOT_FOUND("Recurso no encontrado",404),
    INTERNAL_SERVER_ERROR("Recurso no encontrado",500),
    OK("Solicitud Exitoso",200),
    USER_USED("el usuario ya esta usado",303);

    private String key;
    private Integer value;


    ErrorStatus(String key,Integer value) {
        this.value = value;
        this.key = key;

    }
}
