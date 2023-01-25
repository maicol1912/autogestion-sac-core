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
public class UsuarioPorCaja {
    @Id
    private Integer emp_empresa;

    @Id
    private Integer puc_puntoCredito;

    @Id
    private String tpd_tipodoc;
    @Id
    private Integer npd_secuencia;

    @Id
    private Integer cpp_cajaporpuc;

    @Id
    private String usu_usuario;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date upc_fecha;
    private String upc_estado;
}
