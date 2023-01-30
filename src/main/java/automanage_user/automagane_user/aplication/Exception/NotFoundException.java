package automanage_user.automagane_user.aplication.Exception;


import com.ecommerce_rest.ecommerce_rest.commons.Exceptions.AplicationException;

public class NotFoundException extends AplicationException {

    public NotFoundException() {
        super("Not found user in server.");
    }
}
