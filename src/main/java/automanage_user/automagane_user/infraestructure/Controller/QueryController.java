package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.aplication.services.EmpresaService;
import automanage_user.automagane_user.aplication.services.PuntoCreditoService;
import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PuntoCreditoService puntoCreditoService;

    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/puntocredito/list/{emp_empresa}")
    public List<PuntoCreditoDto> listPuntoCredito(@PathVariable String emp_empresa){
        Integer emp_empresaInteger = Integer.parseInt(emp_empresa);
        return puntoCreditoService.listAll(emp_empresaInteger);
    }

    @GetMapping("/empresa/list")
    public List<EmpresaDto> listEmpresa(){
        return empresaService.listAll();
    }

    @GetMapping("/secuencia/list")
    public Integer lisSecuencia(){
        Integer nroSecuencias = jdbcTemplate.queryForObject("select MAX(npd_secuencia) from sac_cajaporpuc sc \n" +
                "where emp_empresa = 5"+
                "and puc_puntocredito = 62",Integer.class);
        return nroSecuencias;
    }
}
