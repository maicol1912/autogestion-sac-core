package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuarioPorCaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import automanage_user.automagane_user.commons.response.ResponseBody;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @Autowired
    private IEmpleado empleadoService;

    @Autowired
    private IUsuarioPorCaja usuarioPorCajaService;
    @PostMapping("/save/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseBody<?>> saveInfoEmpleado(@RequestBody UsuarioGeneralDto usuarioGeneralDto) throws NoSuchAlgorithmException {
        usuarioService.save(usuarioGeneralDto);
        empleadoService.save(usuarioGeneralDto);
        usuarioPorCajaService.save(usuarioGeneralDto);
        return new ResponseEntity<>(
                ResponseBody
                .init()
                .data(usuarioGeneralDto)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }

}
