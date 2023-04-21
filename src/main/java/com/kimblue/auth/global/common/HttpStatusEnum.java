package com.kimblue.auth.global.common;

import lombok.Getter;

@Getter
public enum HttpStatusEnum {

    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR"),

    UNKNOWN_ERROR(999, "UNKNOWN_ERROR");

    private final int status;
    private final String code;

    HttpStatusEnum(int status, String code) {
        this.status = status;
        this.code = code;
    }

    public static String getCodeByStatus(int status) {
        for (HttpStatusEnum httpStatus : values()) {
            if (httpStatus.status == status) {
                return httpStatus.code;
            }
        }
        return UNKNOWN_ERROR.getCode();
    }
}
