package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import automanage_user.automagane_user.domain.dto.UsuarioDto;
import automanage_user.automagane_user.infraestructure.configuration.EncriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConvertDate convertDate;

    @Autowired
    private EncriptarPassword encriptador;

    private final String INSERT_QUERY = "insert into sai_usuario (usu_usuario, epl_nroid," +
            "usu_password,usu_fecha,usu_estado," +
            "usu_bloqueado) values (?, ? ,? ,? ,? ,?)";

    public UsuarioDto save(UsuarioDto u) throws DataAccessException{
        jdbcTemplate.update(INSERT_QUERY,u.getUsu_usuario(),u.getEpl_nroid(),"354c68cf3602cd244784bb01e14fc256",convertDate.obtenerLocalDate(),
                "I","N");
        return u;
    }



}
