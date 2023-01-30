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
public class EmpleadoDto {
    private String epl_nroid;

    private Integer tpi_tipoid;

    private Integer emp_empresa;

    private Integer tpl_tipopersona;

    private Integer car_cargo;

    private String epl_nombreuno;

    private String epl_nombredos;

    private String epl_apellidouno;

    private String epl_apellidodos;

    private String epl_fecha;

    private String epl_estado;

}
