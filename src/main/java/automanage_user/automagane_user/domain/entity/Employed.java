package automanage_user.automagane_user.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "EMPLOYED")
@Getter
@Setter
public class Employed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String status;

}
