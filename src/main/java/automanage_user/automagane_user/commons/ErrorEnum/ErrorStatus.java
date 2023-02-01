package automanage_user.automagane_user.commons.ErrorEnum;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorStatus {

    NOT_FOUND("Recurso no encontrado",404, HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("Recurso no encontrado",500,HttpStatus.INTERNAL_SERVER_ERROR),
    OK("Solicitud Exitoso",200,HttpStatus.OK),
    USER_USED("el usuario ya esta usado",409,HttpStatus.CONFLICT),
    USER_CEDULA_USED("la cedula del usuario ya esta en uso",409,HttpStatus.CONFLICT),
    EMPLEADO_CEDULA_USED("la cedula del empleado ya esta en uso",409,HttpStatus.CONFLICT),
    EMPRESA_NO_EXISTE("la empresa que intentas ingresar no existe",409,HttpStatus.CONFLICT),
    PUNTO_CREDITO_NO_EXISTE("el punto credito que intentas ingresar no existe",409,HttpStatus.CONFLICT),
    NOMBRE_1_NO_VALIDO("el nombre 1 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    NOMBRE_2_NO_VALIDO("el nombre 2 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    APELLIDO_1_NO_VALIDO("el apellido 1 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    APELLIDO_2_NO_VALIDO("el apellido 2 que intentas ingresar no es valido",409,HttpStatus.CONFLICT);
    private String message;
    private Integer code;

    private HttpStatus status;

    ErrorStatus(String message,Integer code,HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
