package automanage_user.automagane_user.infraestructure.Controller;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuarioPorCaja;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import automanage_user.automagane_user.commons.response.ResponseBody;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class UsuarioController {

    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
    @Autowired
    private IUsuario usuarioService;

    @Autowired
    private IEmpleado empleadoService;

    @Autowired
    private IUsuarioPorCaja usuarioPorCajaService;
    @PostMapping("/save/usuario")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ResponseEntity<ResponseBody<?>> saveUsuario(@RequestBody UsuarioGeneralDto usuarioGeneralDto) throws NoSuchAlgorithmException {
        LOGGER.info("Se inicia proceso de guardado de la entidad usuarioGeneralDto en la tabla de sai_usuario, sai_empleado, sac_usuarioporcaja");

        empleadoService.save(usuarioGeneralDto);
        usuarioService.save(usuarioGeneralDto);
        usuarioPorCajaService.save(usuarioGeneralDto);

        return new ResponseEntity<>(
                ResponseBody
                .init()
                .data(usuarioGeneralDto)
                .code(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }

}
