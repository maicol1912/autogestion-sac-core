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
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean validateUsuarioPorCaja(UsuarioGeneralDto usuarioGeneralDto) {
        String FILTRAR_EXISTENCIA_PUNTO_CREDITO = String.format("select COUNT(*) from sac_puntocredito sp where emp_empresa = %s and puc_puntocredito = %s", usuarioGeneralDto.getEmp_empresa(), usuarioGeneralDto.getPuc_puntoCredito());
        if(jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_PUNTO_CREDITO,int.class).equals(0)){
            throw new NotValidException(CodigoErrorEnum.EMPRESA_NO_EXISTE.getMessage());
        }

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
