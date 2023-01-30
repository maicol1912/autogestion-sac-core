package automanage_user.automagane_user.domain.dto.querys;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CajaSecuenciaPucRowMapper implements RowMapper<CajaSecuenciaPucDto> {

    @Override
    public CajaSecuenciaPucDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CajaSecuenciaPucDto cajaSecuenciaPucDto = new CajaSecuenciaPucDto();
        cajaSecuenciaPucDto.setSecuencia(rs.getInt("npd_secuencia"));
        cajaSecuenciaPucDto.setCajapuc(rs.getInt("cpp_cajaporpuc"));
        cajaSecuenciaPucDto.setTipodoc(rs.getString("tpd_tipodoc"));
        return cajaSecuenciaPucDto;
    }



}
