package automanage_user.automagane_user.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@NoArgsConstructor
@Data
public class UsuarioDto {

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
