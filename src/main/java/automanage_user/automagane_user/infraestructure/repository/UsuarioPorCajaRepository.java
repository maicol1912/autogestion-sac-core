package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.commons.Configuration.ConvertDate;
import automanage_user.automagane_user.domain.dto.UsuarioPorCajaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPorCajaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConvertDate convertDate;

    private final String INSERT_QUERY = "insert into sac_usuarioporcaja (emp_empresa, puc_puntoCredito," +
            "tpd_tipodoc,npd_secuencia,cpp_cajaporpuc,usu_usuario,upc_fecha," +
            "upc_estado) values (?, ? ,? ,? ,? ,? ,?,?)";

    public UsuarioPorCajaDto save(UsuarioPorCajaDto uc) throws DataAccessException {
        jdbcTemplate.update(INSERT_QUERY, uc.getEmp_empresa(), uc.getPuc_puntoCredito(), "CI",1,
                2, uc.getUsu_usuario(), convertDate.convertStringToDate(uc.getUpc_fecha()), "I");
        return uc;
    }
}
