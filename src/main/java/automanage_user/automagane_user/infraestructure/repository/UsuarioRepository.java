package automanage_user.automagane_user.infraestructure.repository;
import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConvertDate convertDate;


    private final String INSERT_QUERY = "insert into sai_usuario (usu_usuario, epl_nroid," +
            "usu_password,usu_fecha,usu_estado," +
            "usu_bloqueado) values (?, ? ,? ,? ,? ,?)";

    private final String INSERT_USUARIO_POR_CAJA_LOG_1 = "INSERT INTO sac_logmaestros ( opc_opcion , usu_usuario , lma_nomtabla , " +
            "lma_operacion , lma_ip , lma_campos_modif , lma_fecha ) VALUES (?,?,?,?,?,?,?)";

    private final String INSERT_USUARIO_POR_CAJA_LOG_2 = "INSERT INTO sac_logmaestros ( opc_opcion , usu_usuario , lma_nomtabla , " +
            "lma_operacion , lma_ip , lma_campos_modif , lma_fecha ) VALUES (?,?,?,?,?,?,?)";

    private final String CAMBIAR_ESTADO_CLIENTE = "update sai_usuario set usu_estado = 'A'\n" +
            "where epl_nroid = ?";

    private final String CONTRASEÑA_USUARIOS = "354c68cf3602cd244784bb01e14fc256";
    @Transactional
    public UsuarioGeneralDto save(UsuarioGeneralDto u) throws DataAccessException{
        jdbcTemplate.update(INSERT_QUERY,u.getUsu_usuario(),u.getEpl_nroid(),CONTRASEÑA_USUARIOS,convertDate.obtenerLocalDate(),
                "I","N");

        jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_LOG_1,69,u.getUsu_usuario(),"sai_perfilporusu","M","10.212.140.17",u.getEpl_nroid().toString()+
                " = Empresa"+u.getEmp_empresa().toString()+"Puc"+u.getPuc_puntoCredito().toString()+"Indicador: N -S ",
                convertDate.obtenerLocalDate());

        jdbcTemplate.update(INSERT_USUARIO_POR_CAJA_LOG_2,69,u.getUsu_usuario(),"sai_perfilporusu","I","10.212.140.17","Indicador: "+
                u.getEpl_nroid()+" - "+u.getPuc_puntoCredito()+" - "+u.getEmp_empresa(),convertDate.obtenerLocalDate());

       return u;
    }

    @Transactional
    public Boolean cambiarEstado(String cedula){
        jdbcTemplate.update(CAMBIAR_ESTADO_CLIENTE,cedula);
        return true;
    }

}
