package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
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

    public UsuarioGeneralDto save(UsuarioGeneralDto u) throws DataAccessException{
        jdbcTemplate.update(INSERT_QUERY,13,u.getEpl_nroid(),u.getEmp_empresa(),2,
                            2,u.getEpl_nombreuno(),u.getEpl_nombredos(),u.getEpl_apellidouno(),u.getEpl_apellidodos(),
                            convertDate.obtenerLocalDate(),"I");
        return u;
    }
}
