package com.opzpy123.webssh.exception;

import com.opzpy123.webssh.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;
    private String data;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, String data) {
        this(code, message);
        this.data = data;
    }

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

}
