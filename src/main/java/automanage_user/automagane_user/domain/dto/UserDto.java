package automanage_user.automagane_user.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String typeIdentity;
    private String numberIdentity;
    private String names;
    private String user_name;
    private String password;
    private String  userBlocked;
    private Date date;
    private String status;
}
