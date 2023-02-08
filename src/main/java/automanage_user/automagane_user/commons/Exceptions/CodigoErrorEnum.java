package automanage_user.automagane_user.commons.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CodigoErrorEnum {

    NOT_FOUND("Recurso no encontrado",404, HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("Error interno del servidor",500,HttpStatus.INTERNAL_SERVER_ERROR),
    NULL_POINTER_EXCEPTION("El objeto que intentas usar es nulo",500,HttpStatus.INTERNAL_SERVER_ERROR),
    OK("Solicitud Exitoso",200,HttpStatus.OK),
    USUARIO_USADO("el usuario ya esta usado",409,HttpStatus.CONFLICT),
    LONGITUD_USUARIO("el usuario que intentas ingresar no es valida debido a su tamaño",409,HttpStatus.CONFLICT),
    USER_CEDULA_USADA("la cedula del usuario ya esta en uso",409,HttpStatus.CONFLICT),
    LONGITUD_CEDULA("la cedula que intentas ingresar no es valida debido a su tamaño",409,HttpStatus.CONFLICT),
    EMPLEADO_CEDULA_USED("la cedula del empleado ya esta en uso",409,HttpStatus.CONFLICT),
    EMPRESA_NO_EXISTE("la empresa que intentas ingresar no existe",409,HttpStatus.CONFLICT),
    PUNTO_CREDITO_NO_EXISTE("el punto credito que intentas ingresar no existe",409,HttpStatus.CONFLICT),
    DATOS_PERSONALES_NO_VLIDOS("los datos ingresados de nombres o apellidos no son validos",409,HttpStatus.CONFLICT),
    NOMBRE_1_NO_VALIDO("el nombre 1 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    NOMBRE_2_NO_VALIDO("el nombre 2 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    APELLIDO_1_NO_VALIDO("el apellido 1 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    APELLIDO_2_NO_VALIDO("el apellido 2 que intentas ingresar no es valido",409,HttpStatus.CONFLICT),
    EMPLEADO_CAMBIAR_ESTADO("el empleado el cual quieres activar no existe",409,HttpStatus.CONFLICT),
    USUARIO_CAMBIAR_ESTADO("el usuario el cual quieres activar no existe",409,HttpStatus.CONFLICT),
    USUARIO_CAJA_CAMBIAR_ESTADO("el usuario caja el cual quieres activar no existe",409,HttpStatus.CONFLICT),
    NOT_TOKEN_VALID("el token que estas usando no es valido",409,HttpStatus.CONFLICT),
    USUARIO_YA_ACTIVO("el usuario que quieres activar ya esta activo",409,HttpStatus.CONFLICT),
    EMPLEADO_YA_ACTIVO("el empleado que quieres activar ya esta activo",409,HttpStatus.CONFLICT),
    USUARIO_CAJA_YA_ACTIVO("el usuario por caja que quieres activar ya esta activo",409,HttpStatus.CONFLICT),
    CEDULA_NO_EXISTE("la cedula no existe",409,HttpStatus.CONFLICT),
    CEDULA_CONTIENE_LETRAS("la cedula que intentas ingresar contiene letras",409,HttpStatus.CONFLICT);
    private String message;
    private Integer code;

    private HttpStatus status;

    CodigoErrorEnum(String message, Integer code, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
