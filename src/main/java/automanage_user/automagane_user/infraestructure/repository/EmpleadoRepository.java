package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class EmpleadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConvertDate convertDate;
    private final String INSERT_QUERY = "insert into sai_empleado (tpi_tipoid, epl_nroid," +
            "emp_empresa,tpl_tipopersona,car_cargo,epl_nombreuno,epl_nombredos," +
            "epl_apellidouno,epl_apellidodos,epl_fecha,epl_estado) values (?, ? ,? ,? ,? ,? ,? ,? ,?,?,?)";

    public EmpleadoDto save(EmpleadoDto e) throws DataAccessException{
        jdbcTemplate.update(INSERT_QUERY,13,e.getEpl_nroid(),e.getEmp_empresa(),2,
                            2,e.getEpl_nombreuno(),e.getEpl_nombredos(),e.getEpl_apellidouno(),e.getEpl_apellidodos(),
                            convertDate.obtenerLocalDate(),"I");
        return e;
    }
}
