package automanage_user.automagane_user.commons.Exceptions.Interceptor;
import automanage_user.automagane_user.aplication.Exception.*;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import automanage_user.automagane_user.commons.response.ResponseBody;

import automanage_user.automagane_user.infraestructure.Controller.QueryController;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionInterceptor {

    private static final Logger LOGGER = Logger.getLogger(QueryController.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBody<?>> exceptionInterceptor(Exception exception) {
        LOGGER.error(String.valueOf(exception.getStackTrace()[0]));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(500)
                        .message(CodigoErrorEnum.INTERNAL_SERVER_ERROR.getMessage())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SpecifiedException.class)
    public  ResponseEntity<ResponseBody<?>> specifiedException(SpecifiedException exception) {
        LOGGER.error(String.valueOf(exception));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(409)
                        .message(exception.getMessage())
                        .build(), HttpStatus.CONFLICT);
    }



    @ExceptionHandler(NotValidException.class)
    public  ResponseEntity<ResponseBody<?>> notValidException(NotValidException exception) {
        LOGGER.error(String.valueOf(exception));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(409)
                        .message(exception.getMessage())
                        .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundFields.class)
    public  ResponseEntity<ResponseBody<?>> notFoundFields(NotFoundFields exception) {
        LOGGER.error(String.valueOf(exception));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(409)
                        .message(exception.getMessage())
                        .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundActivateUser.class)
    public  ResponseEntity<ResponseBody<?>> notFoundActivateUser(NotFoundActivateUser exception) {
        LOGGER.error(String.valueOf(exception));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(409)
                        .message(exception.getMessage())
                        .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotTokenValid.class)
    public  ResponseEntity<ResponseBody<?>> notTokenValid(NotTokenValid exception) {
        LOGGER.error(String.valueOf(exception));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(409)
                        .message(exception.getMessage())
                        .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public  ResponseEntity<ResponseBody<?>> metodoNoSoportado(HttpRequestMethodNotSupportedException exception) {
        LOGGER.error(String.valueOf(exception));
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(null)
                        .code(409)
                        .message("metodo no soportado")
                        .build(), HttpStatus.CONFLICT);
    }
}
