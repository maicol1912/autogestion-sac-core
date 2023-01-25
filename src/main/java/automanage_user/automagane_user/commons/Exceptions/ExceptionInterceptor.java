package automanage_user.automagane_user.commons.Exceptions;
import automanage_user.automagane_user.aplication.Exception.GenericExceptions;
import automanage_user.automagane_user.aplication.Exception.NotFoundException;
import automanage_user.automagane_user.aplication.Exception.SpecifiedException;
import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.commons.response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    public ResponseBody<String> exceptionInterceptor(Exception exception) {

        return ResponseBuilder.failed(exception);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseBody<String> notFoundException(NotFoundException exception) {

        return ResponseBuilder.failed(exception);
    }

    @ExceptionHandler(SpecifiedException.class)
    public ResponseBody<String> specifiedException(SpecifiedException exception) {

        return ResponseBuilder.failed(exception,exception.getStatus());
    }

    @ExceptionHandler(GenericExceptions.class)
    public ResponseBody<String> genericExceptions(GenericExceptions exception) {

        return ResponseBuilder.failed(exception,exception.getStatus());
    }


}
