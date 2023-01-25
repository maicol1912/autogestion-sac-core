package automanage_user.automagane_user.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Empleado {
    @Id
    private String epl_nroid;

    private Integer tpi_tipoid;

    private Integer emp_empresa;

    private Integer puc_puntocredito;

    private Integer tpl_tipopersona;

    private Integer car_cargo;

    private String epl_nombreuno;

    private String epl_nombredos;

    private String epl_apellidouno;

    private String epl_apellidodos;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date epl_fecha;

    private String epl_estado;

}
