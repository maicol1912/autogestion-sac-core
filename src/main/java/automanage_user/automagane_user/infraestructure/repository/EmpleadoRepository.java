package automanage_user.automagane_user.infraestructure.repository;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class EmpleadoRepository {
    private static final Logger LOGGER = Logger.getLogger(EmpleadoRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConvertDate convertDate;
    private final String INSERT_QUERY = "insert into sai_empleado (tpi_tipoid, epl_nroid," +
            "emp_empresa,tpl_tipopersona,car_cargo,epl_nombreuno,epl_nombredos," +
            "epl_apellidouno,epl_apellidodos,epl_fecha,epl_estado) values (?, ? ,? ,? ,? ,? ,? ,? ,?,?,?)";

    private final String CAMBIAR_ESTADO_EMPLEADO = "update sai_usuario set usu_estado = 'A'\n" +
            "where epl_nroid = ?";

    @Transactional
    public UsuarioGeneralDto save(UsuarioGeneralDto u){
        jdbcTemplate.update(INSERT_QUERY,13,u.getEpl_nroid(),u.getEmp_empresa(),2,
                            2,u.getEpl_nombreuno(),u.getEpl_nombredos(),u.getEpl_apellidouno(),u.getEpl_apellidodos(),
                            convertDate.obtenerLocalDate(),"I");

        LOGGER.info(String.format("se realizo la insercion del usuario con cedula -> %s en la tabla sai_empleado",u.getEpl_nroid()));

        return u;

    }
    @Transactional
    public Boolean cambiarEstado(String cedula){
        jdbcTemplate.update(CAMBIAR_ESTADO_EMPLEADO,cedula);
        return true;
    }

}
