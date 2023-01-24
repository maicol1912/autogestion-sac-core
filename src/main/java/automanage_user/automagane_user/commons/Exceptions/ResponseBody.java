package automanage_user.automagane_user.commons.Exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder(builderMethodName = "init")
public class ResponseBody<T> {
    private T data;
    private String message;
    private Integer status;
    private boolean error;

}
