package automanage_user.automagane_user.infraestructure.configuration;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.domain.dto.querys.CajaSecuenciaPucDto;
import automanage_user.automagane_user.domain.dto.querys.CajaSecuenciaPucRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerSecuencia {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer obtenerSecuenciaPorPuntoCredito(UsuarioGeneralDto usuarioGeneralDto){
        Integer nroSecuencias = jdbcTemplate.queryForObject(String.format("select MAX(npd_secuencia) from sac_cajaporpuc sc \n" +
                "where emp_empresa = %S"+
                "and puc_puntocredito = %S",usuarioGeneralDto.getEmp_empresa(),usuarioGeneralDto.getPuc_puntoCredito()),Integer.class);
        System.out.println(nroSecuencias);
        return nroSecuencias;
    }

    public List<CajaSecuenciaPucDto> obtenerCajaPorPuc(UsuarioGeneralDto usuarioPorCajaDto){
        List<CajaSecuenciaPucDto> secuenciaCaja = jdbcTemplate.query(String.format("SELECT npd_secuencia,cpp_cajaporpuc,tpd_tipodoc FROM sac_cajaporpuc " +
                "where emp_empresa=  %S and puc_puntocredito = %S " +
                "and cpp_cajaporpuc <> 0 order by npd_secuencia,cpp_cajaporpuc  asc",usuarioPorCajaDto.getEmp_empresa(),usuarioPorCajaDto.getPuc_puntoCredito()),new CajaSecuenciaPucRowMapper());
        return secuenciaCaja;
    }
}
