package automanage_user.automagane_user.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Data
public class UserCashDto {

    private Long id;
    private Integer company;
    private Integer creditPoint;
    private String user_name;
}
