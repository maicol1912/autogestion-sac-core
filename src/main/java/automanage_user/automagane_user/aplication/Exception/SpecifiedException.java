package automanage_user.automagane_user.aplication.Exception;


import automanage_user.automagane_user.commons.Exceptions.AplicationException;

public class SpecifiedException extends AplicationException {
    private Integer status;
    public SpecifiedException(String message,Integer status) {
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
