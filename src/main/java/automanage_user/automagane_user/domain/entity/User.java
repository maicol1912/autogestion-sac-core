package automanage_user.automagane_user.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String usu_usuario;

    private String epl_nroid;

    private String usu_password;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date usu_fecha;

    private String usu_estado;

    private String usu_email;

    private String usu_usuariocorreo;

    private String usu_pswcorreo;

    private String usu_bloqueado;
}
