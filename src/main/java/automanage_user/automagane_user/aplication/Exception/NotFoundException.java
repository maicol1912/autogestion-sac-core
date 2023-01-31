package automanage_user.automagane_user.aplication.Exception;


import automanage_user.automagane_user.commons.Exceptions.AplicationException;

public class NotFoundException extends AplicationException {

    public NotFoundException() {
        super("Not found user in server.");
    }
}
