package automanage_user.automagane_user.commons.response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "init")
public class ResponseBody<T> {
    private T data;
    private String message;
    private Integer code;
    private boolean error;




}
