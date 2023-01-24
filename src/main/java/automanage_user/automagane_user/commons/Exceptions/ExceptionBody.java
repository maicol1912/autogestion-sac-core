package automanage_user.automagane_user.commons.Exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder(builderMethodName = "init")
public class ExceptionBody {
    private boolean error;
    private String filename;
    private String method;
    private String clazz;
    private String message;
    private String localizedMessage;
    private Integer line;

}
