package com.unitech.exception;

import com.unitech.codeEnum.ErrorCodeEnum;
import lombok.Data;

@Data
public class UniTechException extends RuntimeException {

    private ErrorCodeEnum errorCodeEnum;

    public UniTechException (String message){
        super(message);
    }
    public UniTechException (String message , ErrorCodeEnum errorCodeEnum){
        super(message );
        this.errorCodeEnum=errorCodeEnum;
    }
    public UniTechException ( ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.name() );
        this.errorCodeEnum=errorCodeEnum;
    }
}
