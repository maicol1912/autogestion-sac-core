package automanage_user.automagane_user.infraestructure.configuration;

import automanage_user.automagane_user.domain.dto.UsuarioPorCajaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ObtenerSecuencia {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer obtenerSecuenciaPorPuntoCredito(UsuarioPorCajaDto usuarioPorCajaDto){
        System.out.println("entre acaaaaa mano");
        System.out.println(usuarioPorCajaDto.getEmp_empresa());
        System.out.println(usuarioPorCajaDto.getPuc_puntoCredito());
        Integer nroSecuencias = jdbcTemplate.queryForObject(String.format("select MAX(npd_secuencia) from sac_cajaporpuc sc \n" +
                "where emp_empresa = %S"+
                "and puc_puntocredito = %S",usuarioPorCajaDto.getEmp_empresa(),usuarioPorCajaDto.getPuc_puntoCredito()),Integer.class);
        System.out.println(nroSecuencias);
        return nroSecuencias;
    }

}
