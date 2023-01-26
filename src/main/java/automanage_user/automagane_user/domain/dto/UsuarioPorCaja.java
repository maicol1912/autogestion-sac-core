package automanage_user.automagane_user.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@NoArgsConstructor
@Data
public class UsuarioPorCaja {

    private Integer emp_empresa;
    private Integer puc_puntoCredito;
    private String tpd_tipodoc;
    private Integer npd_secuencia;
    private Integer cpp_cajaporpuc;
    private String usu_usuario;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date upc_fecha;
    private String upc_estado;
}
