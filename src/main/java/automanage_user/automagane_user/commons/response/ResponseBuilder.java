package automanage_user.automagane_user.commons.response;

import automanage_user.automagane_user.commons.response.ResponseBody;
import ch.qos.logback.core.status.ErrorStatus;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ResponseBuilder {

    private final String MESSAGE = "Success process in server";

    public <T> ResponseBody<T> success(T data) {
        return ResponseBody
                .<T>init()
                .data(data)
                .message(MESSAGE)
                .status(200)
                .build();
    }


    public ResponseBody<String> failed(Throwable exception) {
        return ResponseBody
                .<String>init()
                .message(exception.getMessage())
                .status(500)
                .build();
    }



    public ResponseBody<String> failed(Throwable exception, HttpStatus status) {
        return ResponseBody
                .<String>init()
                .message(exception.getMessage())
                .status(status.value())
                .build();
    }


    public ResponseBody<String> failed(Throwable exception,Integer code) {
        return ResponseBody
                .<String>init()
                .message(exception.getMessage())
                .status(500)
                .build();
    }

    public ResponseBody<String> specifiedFailed(String message) {
        return ResponseBody
                .<String>init()
                .message(message)
                .status(500)
                .error(true)
                .build();
    }
}
