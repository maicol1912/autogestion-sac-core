package automanage_user.automagane_user.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@NoArgsConstructor
@Data
public class UsuarioPorCajaDto {

    private Integer emp_empresa;
    private Integer puc_puntoCredito;
    private String usu_usuario;
    private String upc_fecha;
    private String upc_estado;
}
