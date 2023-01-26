package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.domain.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Component
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY = "insert into sai_usuario (usu_usuario, epl_nroid," +
            "usu_password,usu_fecha,usu_estado,usu_email,usu_usuariocorreo," +
            "usu_pswcorreo,usu_bloqueado) values (?, ? ,? ,? ,? ,? ,? ,?,?)";

    public UsuarioDto save(UsuarioDto u) throws DataAccessException {
        jdbcTemplate.update(INSERT_QUERY,u.getUsu_usuario(),u.getEpl_nroid(),u.getUsu_password(),u.getUsu_fecha(),
                u.getUsu_estado(),u.getUsu_email(),u.getUsu_usuariocorreo(),u.getUsu_pswcorreo(),u.getUsu_bloqueado());
        return u;
    }



}
