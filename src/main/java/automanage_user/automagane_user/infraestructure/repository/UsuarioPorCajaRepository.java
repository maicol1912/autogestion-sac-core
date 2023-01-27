package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.UsuarioPorCajaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPorCajaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY = "insert into sac_usuarioporcaja (emp_empresa, puc_puntoCredito," +
            "tpd_tipodoc,npd_secuencia,cpp_cajaporpuc,usu_usuario,upc_fecha," +
            "upc_estado) values (?, ? ,? ,? ,? ,? ,?,?)";

    public UsuarioPorCajaDto save(UsuarioPorCajaDto uc) throws DataAccessException {
        jdbcTemplate.update(INSERT_QUERY, uc.getEmp_empresa(), uc.getPuc_puntoCredito(), uc.getTpd_tipodoc(), uc.getNpd_secuencia(),
                uc.getCpp_cajaporpuc(), uc.getUsu_usuario(), uc.getUpc_fecha(), uc.getUpc_estado());
        return uc;
    }
}
