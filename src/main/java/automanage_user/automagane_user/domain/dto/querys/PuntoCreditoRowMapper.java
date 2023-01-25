package automanage_user.automagane_user.domain.dto.querys;


import automanage_user.automagane_user.domain.entity.Employed;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PuntoCreditoRowMapper implements RowMapper<PuntoCreditoDto> {


    @Override
    public PuntoCreditoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PuntoCreditoDto puntoCreditoDto = new PuntoCreditoDto();
        puntoCreditoDto.setPuc_nombre(rs.getString("puc_nombre").replaceAll("\\s", ""));
        puntoCreditoDto.setPuc_puntocredito(rs.getInt("puc_puntocredito"));
        return puntoCreditoDto;
    }
}
