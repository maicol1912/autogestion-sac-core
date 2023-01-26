package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PuntoCreditoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PuntoCreditoDto>listAll(){
        List<PuntoCreditoDto> listPuntoCredito = jdbcTemplate.query("Select puc_nombre,puc_puntocredito from punto_credito",new PuntoCreditoRowMapper());
        System.out.println(listPuntoCredito);
        return listPuntoCredito;
    }


}
