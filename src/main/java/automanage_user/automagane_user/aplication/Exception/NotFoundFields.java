package automanage_user.automagane_user.aplication.Exception;

import automanage_user.automagane_user.commons.Exceptions.AplicationException;

public class NotFoundFields extends AplicationException {
    private Integer code;
    public NotFoundFields(String message,Integer code) {
        super(message);
        this.code = code;
    }
}
