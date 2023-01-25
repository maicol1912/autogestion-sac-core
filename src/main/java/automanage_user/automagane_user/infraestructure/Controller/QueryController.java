package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.EmpresaRowMapper;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sumas/usuarios")
@CrossOrigin(value = "*")
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/puntocredito/list")
    public List<PuntoCreditoDto> listPuntoCredito(){
        List<PuntoCreditoDto> listPuntoCredito = jdbcTemplate.query("Select puc_nombre,puc_puntocredito from punto_credito",new PuntoCreditoRowMapper());
        System.out.println(listPuntoCredito);
        return listPuntoCredito;
    }

    @GetMapping("/empresa/list")
    public List<EmpresaDto> listEmpresa(){
        List<EmpresaDto> listEmpresa = jdbcTemplate.query("Select emp_empresa,emp_nombre from emp_empresa",new EmpresaRowMapper());
        System.out.println(listEmpresa);
        return listEmpresa;
    }
}
