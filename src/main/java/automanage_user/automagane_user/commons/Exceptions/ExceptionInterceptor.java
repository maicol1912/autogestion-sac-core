package automanage_user.automagane_user.commons.Exceptions;
import automanage_user.automagane_user.aplication.Exception.GenericExceptions;
import automanage_user.automagane_user.aplication.Exception.NotFoundException;
import automanage_user.automagane_user.aplication.Exception.SpecifiedException;
import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.commons.response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionInterceptor.class);
    @ExceptionHandler(Exception.class)
    public ResponseBody<String> exceptionInterceptor(Exception exception) {
        LOGGER.info(String.valueOf(exception));
        return ResponseBuilder.failed(exception);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseBody<String> notFoundException(NotFoundException exception) {
        LOGGER.info(String.valueOf(exception));
        return ResponseBuilder.failed(exception);
    }

    @ExceptionHandler(SpecifiedException.class)
    public ResponseBody<String> specifiedException(SpecifiedException exception) {
        LOGGER.info(String.valueOf(exception));
        return ResponseBuilder.failed(exception,exception.getStatus());
    }

    @ExceptionHandler(GenericExceptions.class)
    public ResponseBody<String> genericExceptions(GenericExceptions exception) {
        LOGGER.info(String.valueOf(exception));
        return ResponseBuilder.failed(exception,exception.getStatus());
    }


}
