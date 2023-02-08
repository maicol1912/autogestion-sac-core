package automanage_user.automagane_user.aplication.Validaciones;
import automanage_user.automagane_user.aplication.Exception.NotFoundActivateUser;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuarioPorCajaService {
    private static final Logger LOGGER = Logger.getLogger(ValidacionUsuarioPorCajaService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean validateUsuarioPorCaja(UsuarioGeneralDto usuarioGeneralDto) {
        LOGGER.info("se inicia validacion de los campos del usuario por caja");
        String FILTRAR_EXISTENCIA_PUNTO_CREDITO = String.format("select COUNT(*) from sac_puntocredito sp where emp_empresa = %s and puc_puntocredito = %s", usuarioGeneralDto.getEmp_empresa(), usuarioGeneralDto.getPuc_puntoCredito());
        if(jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_PUNTO_CREDITO,int.class).equals(0)){
            throw new NotValidException(CodigoErrorEnum.EMPRESA_NO_EXISTE.getMessage());
        }
        if(!(usuarioGeneralDto.getUsu_usuario().length()>4 && usuarioGeneralDto.getUsu_usuario().length()<10)){

            throw new NotValidException(CodigoErrorEnum.LONGITUD_USUARIO.getMessage());
        }
        LOGGER.info("se valida campos del usuario por caja y estos son -> validos");
        return true;
    }

    public Boolean validateCambioEstadoUsuarioPorCaja(String cedula){
        String FILTRAR_EXISTENCIA_USUARIO_CAJA = String.format("select COUNT(distinct su.usu_usuario) from sai_usuario su\n" +
                "inner join sac_usuarioporcaja uc on su.usu_usuario = uc.usu_usuario \n" +
                "where su.epl_nroid = '%s'",cedula);

        if(FILTRAR_EXISTENCIA_USUARIO_CAJA.equals(0)){
            throw new NotFoundActivateUser(CodigoErrorEnum.USUARIO_CAJA_CAMBIAR_ESTADO.getMessage());
        }
        return true;
    }
}
