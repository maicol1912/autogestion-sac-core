package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.aplication.Validaciones.*;
import automanage_user.automagane_user.aplication.services.CambiarEstadoService;
import automanage_user.automagane_user.aplication.services.TokenService;
import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.infraestructure.configuration.EncodeUrlVerification;
import org.modelmapper.ModelMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class CambioEstadoUsuarioController {

    private static final Logger LOGGER = Logger.getLogger(CambioEstadoUsuarioController.class);
    @Autowired
    private EncodeUrlVerification encriptarUrl;



    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ValidacionEmpleadoService validacionEmpleadoService;

    @Autowired
    private ValidacionUsuarioService validacionUsuarioService;

    @Autowired
    private ValidacionUsuarioPorCajaService validacionUsuarioPorCajaService;

    @Autowired
    private ValidacionCambioEstadoUsuario validacionCambioEstadoUsuario;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private CambiarEstadoService cambiarEstadoService;

    @GetMapping("/generate/token")
    @Transactional
    public ResponseEntity<ResponseBody<?>>generateToken(){
        String token = tokenService.generateToken();
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(token)
                        .code(200)
                        .message("se ha generado su token")
                        .build(),HttpStatus.OK);
    }

    @GetMapping("/validate/activar/{cedula}")
    @Transactional
    public ResponseEntity<ResponseBody<?>>cambiarEstadoUsuario(@PathVariable String cedula,@RequestHeader("Authorization") String authorization){
        tokenService.validarToken(authorization);
        cambiarEstadoService.cambiarEstadoUsuarioGeneral(cedula);
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(cedula)
                        .code(200)
                        .message("se ha cambiado el estado del usuario, ahora su estado es activo")
                        .build(),HttpStatus.OK);
    }


}
