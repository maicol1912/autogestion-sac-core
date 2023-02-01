package automanage_user.automagane_user.aplication.Exception;

import automanage_user.automagane_user.commons.Exceptions.AplicationException;
import org.springframework.http.HttpStatus;

public class NotValidException extends AplicationException {

    private HttpStatus status;
    private Integer code;

    public NotValidException(String message,HttpStatus status,Integer code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
