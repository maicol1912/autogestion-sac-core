package automanage_user.automagane_user.aplication.Validaciones;
import automanage_user.automagane_user.aplication.Exception.NotFoundActivateUser;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ValidacionEmpleadoService {

    private static final Logger LOGGER = Logger.getLogger(ValidacionEmpleadoService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ValidacionCaracteres validacionCaracteres;

    public Boolean validateEmpleado(UsuarioGeneralDto usuarioGeneralDto){
        LOGGER.info("se inicia validacion de los campos del empleado");
        String FILTRAR_EXISTENCIA_CEDULA = String.format("select COUNT(*) from sai_empleado where epl_nroid = '%s'",usuarioGeneralDto.getEpl_nroid());
        String FILTRAR_EXISTENCIA_EMPRESA = String.format("select COUNT(*) from sac_empresa where emp_empresa = '%s'",usuarioGeneralDto.getEmp_empresa());

        if(!jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_CEDULA,int.class).equals(0)){
            throw new NotValidException(CodigoErrorEnum.EMPLEADO_CEDULA_USED.getMessage());
        }

        if(jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_EMPRESA,int.class).equals(0)){
            throw new NotValidException(CodigoErrorEnum.EMPRESA_NO_EXISTE.getMessage());
        }
        if(!(usuarioGeneralDto.getEpl_nroid().length()>5 && usuarioGeneralDto.getEpl_nroid().length()<11)){
            throw new NotValidException(CodigoErrorEnum.LONGITUD_CEDULA.getMessage());
        }

        if(!validacionCaracteres.validarCaracter(usuarioGeneralDto)){
            throw new NotValidException(CodigoErrorEnum.DATOS_PERSONALES_NO_VLIDOS.getMessage());
        }

        LOGGER.info("se valida campos del empleado y estos son -> validos");
        return true;
    }

    public Boolean validateCambioEstadoEmpleado(String cedula){
        String FILTRAR_EXISTENCIA_EMPLEADO = String.format("select COUNT(*) from sai_empleado se2 where epl_nroid = '%s'",cedula);
        if(FILTRAR_EXISTENCIA_EMPLEADO.equals(0)){
            throw new NotFoundActivateUser(CodigoErrorEnum.EMPLEADO_CAMBIAR_ESTADO.getMessage());
        }
        return true;
    }
}
