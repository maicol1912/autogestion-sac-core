package automanage_user.automagane_user.aplication.Validaciones;
import automanage_user.automagane_user.commons.ErrorEnum.ErrorStatus;
import automanage_user.automagane_user.aplication.Exception.NotValidException;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ValidacionUsuarioPorCajaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean validateUsuarioPorCaja(UsuarioGeneralDto usuarioGeneral) {
        String FILTRAR_EXISTENCIA_PUNTO_CREDITO = String.format("select COUNT(*) from sac_puntocredito sp where emp_empresa = %s and puc_puntocredito = %s", usuarioGeneral.getEmp_empresa(), usuarioGeneral.getPuc_puntoCredito());

        if(jdbcTemplate.queryForObject(FILTRAR_EXISTENCIA_PUNTO_CREDITO,int.class).equals(0)){
            throw new NotValidException("La empresa que intentas ingresar en el usuario por acaja no existe", ErrorStatus.NOT_FOUND.getStatus(), ErrorStatus.NOT_FOUND.getCode());
        }
        return true;
    }
}
