package automanage_user.automagane_user.aplication.Exception;

import automanage_user.automagane_user.commons.Exceptions.AplicationException;
import org.springframework.http.HttpStatus;

public class NotValidException extends AplicationException {

    private HttpStatus status;
    private Integer code;

    public NotValidException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
