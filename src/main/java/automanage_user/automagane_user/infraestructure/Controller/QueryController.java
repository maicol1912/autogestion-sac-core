package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.aplication.services.EmpresaService;
import automanage_user.automagane_user.aplication.services.PuntoCreditoService;
import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.infraestructure.configuration.EncriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private EncriptarPassword encriptarPassword;
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
    public String listSecuencia(){
        return "gola";
    }
}
