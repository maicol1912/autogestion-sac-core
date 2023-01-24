package automanage_user.automagane_user.aplication.Exception;

import com.ecommerce_rest.ecommerce_rest.commons.Exceptions.AplicationException;

public class GenericExceptions extends AplicationException {
    private Integer status;

    public GenericExceptions(String message,Integer code) {
        super(message);
        this.status = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer code) {
        this.status = code;
    }
}
