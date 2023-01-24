package automanage_user.automagane_user.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
public class EmployedDto {
    private Long id;
    private String typeId;
    private String numberId;
    private Integer company;
    private String typePerson;
    private String charge;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Date date;
    private String status;

}
