package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.aplication.services.EmpresaService;
import automanage_user.automagane_user.aplication.services.PuntoCreditoService;
import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.infraestructure.configuration.ConvertDate;
import automanage_user.automagane_user.infraestructure.repository.EmpleadoRepository;
import automanage_user.automagane_user.infraestructure.repository.UsuarioPorCajaRepository;
import automanage_user.automagane_user.infraestructure.repository.UsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class QueryController {
    private static final Logger LOGGER = Logger.getLogger(QueryController.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PuntoCreditoService puntoCreditoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private UsuarioPorCajaRepository usuarioPorCajaRepository;
    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/puntocredito/list/{emp_empresa}")
    public List<PuntoCreditoDto> listPuntoCredito(@PathVariable String emp_empresa){
        LOGGER.info("se inicia listado de los puntos de credito");
        Integer emp_empresaInteger = Integer.parseInt(emp_empresa);
        return puntoCreditoService.listAll(emp_empresaInteger);
    }

    @GetMapping("/empresa/list")
    public List<EmpresaDto> listEmpresa(){
        LOGGER.info("se inicia listado de las empresas");
        return empresaService.listAll();
    }

    @GetMapping("/usuario/cambiar/{cedula}")
    public String cambiarEstado(@PathVariable String cedula){
        usuarioRepository.cambiarEstado(cedula);
        empleadoRepository.cambiarEstado(cedula);
        usuarioPorCajaRepository.cambiarEstado(cedula);
        return "hola";
    }
}
