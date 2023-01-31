package automanage_user.automagane_user.aplication.Exception;

import automanage_user.automagane_user.commons.Exceptions.AplicationException;

public class NotValidException extends AplicationException {

    private Integer status;
    public NotValidException(String message,Integer status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
