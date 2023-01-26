package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String INSERT_QUERY = "insert into sai_empleado (tpi_tipoid, epl_nroid," +
            "emp_empresa,tpl_tipopersona,car_cargo,epl_nombreuno,epl_nombredos," +
            "epl_apellidouno,epl_apellidodos,epl_fecha,epl_estado) values (?, ? ,? ,? ,? ,? ,? ,? ,? ,?,?)";

    public EmpleadoDto save(EmpleadoDto e) throws DataAccessException {
        jdbcTemplate.update(INSERT_QUERY,e.getTpi_tipoid(),e.getEpl_nroid(),e.getEmp_empresa(),e.getTpl_tipopersona(),
                            e.getCar_cargo(),e.getEpl_nombreuno(),e.getEpl_nombredos(),e.getEpl_apellidouno(),e.getEpl_apellidodos(),
                            e.getEpl_fecha(),e.getEpl_estado());
        return e;
    }
}
